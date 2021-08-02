package com.mabaya.sponserads.service.impl;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepositpry;
	
	@Override
	public CampaignEntity createCampaign(String name, CampaignEntity campaignEntity) {
		campaignEntity.setName(name);

		campaignEntity = campaignRepository.save(campaignEntity);

		return campaignEntity;
	}

	@Override
	public ProductEntity serveAd(String category) {
		List<ProductEntity> productEntities = productRepositpry.findByCategory(category);
		ProductEntity returnedProduct;
		
		if (productEntities.isEmpty()) {
			returnedProduct = productRepositpry.getHighestBid();
		} else {
			productEntities.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));
			
			returnedProduct = productEntities.get(0);
		}
		
		return returnedProduct;
	}
}
