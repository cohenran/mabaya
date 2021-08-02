package com.mabaya.sponserads.service.impl;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepositpry;
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
	private ProductRepositpry productRepositpry;
	
	@Override
	public CampaignEntity createCampaign(String name, CampaignEntity campaignEntity) {
		campaignEntity.setName(name);

		campaignRepository.save(campaignEntity);

		return campaignEntity;
	}

	@Override
	public ProductEntity serveAd(String category) {
		List<ProductEntity> productEntities = productRepositpry.findByCategory(category);
		ProductEntity returnedProduct;
		
		if (productEntities.isEmpty()) {
			returnedProduct = productRepositpry.getHighestBid();
		} else {
			productEntities.sort(new Comparator<ProductEntity>() {
				@Override
				public int compare(ProductEntity o1, ProductEntity o2) {
					return o1.getPrice().compareTo(o2.getPrice());
				}
			});
			
			returnedProduct = productEntities.get(0);
		}
		
		return returnedProduct;
	}
}
