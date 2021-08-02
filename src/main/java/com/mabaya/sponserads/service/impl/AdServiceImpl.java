package com.mabaya.sponserads.service.impl;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.dao.ProductToCampaingsRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import com.mabaya.sponserads.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepositpry;
	@Resource
	private ProductToCampaingsRepository productToCampaingsRepository;

	@Override
	public CampaignEntity createCampaign(String name, final CampaignEntity campaignEntity) {
		campaignEntity.setName(name);
		List<ProductEntity> productEntity = productRepositpry.getById(
				campaignEntity.getProductToCampaingsEntity().stream().map(pc -> pc.getProductEntity().getId()).collect(Collectors.toList()));
		
		List<ProductToCampaingsEntity> productToCampaignsEntities = productEntity.stream().map(p -> new ProductToCampaingsEntity(p, campaignEntity)).collect(Collectors.toList());
		
		campaignEntity.setProductToCampaingsEntity(productToCampaignsEntities);

		CampaignEntity savedCampaignEntity = campaignRepository.save(campaignEntity);
		
		productToCampaingsRepository.saveAll(productEntity.stream().map(p -> new ProductToCampaingsEntity(p, campaignEntity)).collect(Collectors.toList()));
		
		return savedCampaignEntity;
	}

	@Override
	@Transactional
	public ProductEntity serveAd(String category) {
		return null;
	}/*
		List<ProductEntity> productEntities = productRepositpry.findByCategory(category);
		ProductEntity returnedProduct;

		if (productEntities.isEmpty()) {
			returnedProduct = productRepositpry.getHighestBid();
		} else {
			// get all the active campaign
			List<CampaignEntity> activeCampaigns = campaignRepository.getActiveCampaigns();
			
			// from all the active campaigns, get all the products to a list of list
			List<List<ProductEntity>> listOfProductsByCampaign = activeCampaigns.stream().map(ac -> ac.getProductEntities()).collect(Collectors.toList());
			
			// combine the lists
			List<ProductEntity> singleList =
					listOfProductsByCampaign.stream()
							.flatMap(List::stream)
							.collect(Collectors.toList());
			// filter by selected category
			singleList = singleList.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toList());
			// sort them to make the MAX on top
			singleList.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));

			returnedProduct = singleList.get(0);
		}

		return returnedProduct;
	}*/
}
