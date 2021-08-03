package com.mabaya.sponserads.system_tests;

import com.mabaya.sponserads.Application;
import com.mabaya.sponserads.components.ProductsGenerator;
import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.exception.BadInitException;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import com.mabaya.sponserads.service.AdService;
import com.mabaya.sponserads.utils.DBUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Slf4j
@SpringBootTest(classes = {
		ProductsGenerator.class,
		Application.class
})
@RunWith(SpringRunner.class)
public class AdServiceTest {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepositpry;

	@Autowired
	private AdService adService;

	@Autowired
	private DBUtils dbUtils;

	@Test
	public void createCampaign() {
		ProductToCampaingsEntity productToCampaingsEntity = new ProductToCampaingsEntity(dbUtils.getRandomProducts().get(0));
		CampaignEntity testCampaignEntity = new CampaignEntity("test", Collections.singletonList(productToCampaingsEntity), LocalDate.of(2021, 01, 01), 0.1f);

		CampaignEntity returnedCampaignEntity = adService.createCampaign(testCampaignEntity);

		assertEquals(testCampaignEntity, returnedCampaignEntity);
	}

	@Test
	public void serveAdNoPromotedProductTest() {
		Optional<ProductEntity> highestPriceProduct = productRepositpry.findAll().stream().max(Comparator.comparing(ProductEntity::getPrice));

		if (!highestPriceProduct.isPresent()) {
			throw new BadInitException("No products were inited :(");
		}

		ProductEntity productEntity = adService.serveAd("BAD_CATEGORY");

		assertEquals(productEntity, highestPriceProduct.get());
	}

	@Test
	public void serveAdGoodPromotedProductTest() {
		Optional<ProductEntity> highestPriceProduct = productRepositpry.getHighestBidWithActiveCampaign("Games");

		if (!highestPriceProduct.isPresent()) {
			throw new BadInitException("No products were inited :(");
		}

		ProductEntity productEntity = adService.serveAd(highestPriceProduct.get().getCategory());
		
		assertEquals(productEntity, highestPriceProduct.get());
	}
}
