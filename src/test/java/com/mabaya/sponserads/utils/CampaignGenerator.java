package com.mabaya.sponserads.utils;

import com.mabaya.sponserads.components.ProductsGenerator;
import com.mabaya.sponserads.controller.AdsController;
import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.dao.ProductToCampaignsRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CampaignGenerator extends ProductsGenerator {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private ProductToCampaignsRepository productToCampaingsRepository;

	@Autowired
	private AdsController adsController;

	@Value("${consts.campaigns_amount}")
	private Long campaignsAmount;

	private Random rnd = new Random();

	/**
	 * Make sure that many campaign are created with many products
	 */
	@PostConstruct
	public void generate() {
		List<ProductEntity> productEntities = productRepository.findAll();

		for (int i = 0; i < campaignsAmount; i++) {
			List<ProductEntity> productEntities1 = productEntities.stream().filter(p -> rnd.nextInt(100) > 90).collect(Collectors.toList());
			
			List<ProductToCampaingsEntity> productToCampaignsEntities = productEntities1.stream().map(ProductToCampaingsEntity::new).collect(Collectors.toList());
			CampaignEntity campaignEntity = new CampaignEntity(String.valueOf(i), productToCampaignsEntities, LocalDate.now(), rnd.nextFloat());
		
			adsController.createCampaign(String.valueOf(i), campaignEntity);
		}
	}
}
