package com.mabaya.sponserads.utils;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.model.ProductEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DBUtils {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepository;
	
	private Random rnd = new Random();
	private List<ProductEntity> productEntities;
	
	public List<ProductEntity> getRandomProducts() {
		List<ProductEntity> productEntities = productRepository.findAll();
		
		int productsNum = rnd.nextInt(15) + 1;
		List<ProductEntity> innerProducts = new ArrayList<>();
		
		for (int j = 0; j < productsNum; j++) {
			innerProducts.add(productEntities.get(rnd.nextInt(productEntities.size())));
		}
		
		return innerProducts;
	}
}
