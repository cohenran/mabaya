package com.mabaya.sponserads.system_tests;

import com.mabaya.sponserads.Application;
import com.mabaya.sponserads.components.ProductsGenerator;
import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.AdService;
import com.mabaya.sponserads.utils.DBUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@Slf4j
@SpringBootTest(classes = {
		ProductRepository.class,
		ProductsGenerator.class,
		Application.class
})
@RunWith(SpringRunner.class)
@Import(Application.class)
public class AdServiceTest {
	@Mock
	private CampaignRepository campaignRepository;
	@Mock
	private ProductRepository productRepositpry;

	@Autowired
	private AdService adService;

	@Autowired
	private DBUtils dbUtils;
	
	private List<ProductEntity> productEntities;
	
	private Random rnd = new Random();
	
	@Test
	@Transactional
	public void createCampaign() {		
		CampaignEntity testCampaignEntity = new CampaignEntity("test", dbUtils.getRandomProducts(), LocalDate.of(2021, 01, 01), 0.1f);

		CampaignEntity returnedCampaignEntity = adService.createCampaign("test", testCampaignEntity);
		
		assertEquals(testCampaignEntity, returnedCampaignEntity);
	}
}
