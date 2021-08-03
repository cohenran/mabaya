package com.mabaya.sponserads.components;

import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.dao.ProductToCampaignsRepository;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Component
public class ProductsGenerator {
	@Resource
	private ProductRepository productRepositpry;

	@Value("${consts.category}")
	private String[] categories;
	@Value("${consts.products_amount}")
	private Long productsAmount;
	@Resource
	private ProductToCampaignsRepository productToCampaingsRepository;

	private Random rnd = new Random();

	@PostConstruct
	public void generate() {
		log.info("Starting to generate products...");
		
		for (int i = 0; i < productsAmount; i++) {
			int randomCategoryInd = rnd.nextInt(categories.length);
			String randomCategory = categories[randomCategoryInd];
			String productSerial = UUID.randomUUID().toString();
			
			ProductEntity productEntity = new ProductEntity(randomCategory, randomCategory, rnd.nextFloat(), productSerial);
			ProductToCampaingsEntity productToCampaingsEntity = new ProductToCampaingsEntity(productEntity);

			productToCampaingsEntity = productToCampaingsRepository.save(productToCampaingsEntity);
			
			productEntity.setProductToCampaingsEntity(Collections.singletonList(productToCampaingsEntity));
			productRepositpry.save(productEntity);
		}

		log.info("Product generation done!");
	}
}