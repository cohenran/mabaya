package com.mabaya.sponserads.unit_test;


import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.impl.AdServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(SpringRunner.class)
public class AdServiceTest {
	@Mock
	private CampaignRepository campaignRepository;
	@Mock
	private ProductRepository productRepositpry;

	@InjectMocks
	private AdServiceImpl adService;
	
	private static final String GAMES = "Games";
	private final ProductEntity PRODUCT = new ProductEntity("test", "test", 0.1f, "abc");

	/**
	 * Remove the TEST log file before/after the test
	 */
	@Before
	public void init() {
	}

	@Test
	public void createCampaign() {
		CampaignEntity testCampaignEntity = new CampaignEntity("test", Collections.singletonList(PRODUCT), LocalDate.of(2021, 01, 01), 0.1f);

		when(campaignRepository.save(testCampaignEntity)).thenReturn(testCampaignEntity);

		CampaignEntity returnedCampaignEntity = adService.createCampaign("test", testCampaignEntity);

		assertEquals(returnedCampaignEntity, testCampaignEntity);
	}

	@Test
	public void serveAd() {
		when(productRepositpry.findByCategory(GAMES)).thenReturn(Collections.singletonList(PRODUCT));
		ProductEntity returnedProduct = adService.serveAd(GAMES);

		assertEquals(returnedProduct, PRODUCT);		
	}
}
