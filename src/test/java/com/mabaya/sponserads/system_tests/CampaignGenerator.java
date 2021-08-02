package com.mabaya.sponserads.system_tests;

import com.mabaya.sponserads.components.ProductsGenerator;
import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.utils.DBUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class CampaignGenerator extends ProductsGenerator {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepository;

	@Autowired
	private DBUtils dbUtils;
	
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
			List<ProductEntity> innerProducts = dbUtils.getRandomProducts();
			
			CampaignEntity campaignEntity = new CampaignEntity(String.valueOf(i), innerProducts, LocalDate.now(), rnd.nextFloat());
			campaignRepository.save(campaignEntity);
		}
	}
}
