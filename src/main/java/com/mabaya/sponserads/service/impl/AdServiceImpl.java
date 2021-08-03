package com.mabaya.sponserads.service.impl;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepository;
import com.mabaya.sponserads.dao.ProductToCampaignsRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import com.mabaya.sponserads.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepository productRepositpry;
	@Resource
	private ProductToCampaignsRepository productToCampaingsRepository;

	@Override
	public CampaignEntity createCampaign(final CampaignEntity campaignEntity) {
		campaignEntity.setName(campaignEntity.getName());
		List<ProductEntity> productEntity = productRepositpry.getById(
				campaignEntity.getProductToCampaingsEntity().stream().map(pc -> pc.getProductEntity().getId()).collect(Collectors.toList()));
		
		List<ProductToCampaingsEntity> productToCampaignsEntities = productToCampaingsRepository.getByProductId(productEntity.stream().map(p -> p.getId()).collect(Collectors.toList()));

		CampaignEntity savedCampaignEntity = campaignRepository.save(campaignEntity);
		productToCampaignsEntities.forEach(p -> p.setCampaignEntity(savedCampaignEntity));
		productToCampaingsRepository.saveAll(productToCampaignsEntities);
		
		return savedCampaignEntity;
	}

	@Override
	@Transactional
	public ProductEntity serveAd(String category) {
		List<ProductEntity> productEntities = productRepositpry.findByCategory(category);
		
		List<ProductEntity> activeCampaigns = productRepositpry.getCampaignsByProductCategory(category);
		
		ProductEntity returnedProduct;

		if (productEntities.isEmpty() || activeCampaigns.size() == 0) {
			returnedProduct = productRepositpry.getHighestBid();
		} else {
			// from all the active campaigns, get all the products to a list of list
			List<List<ProductToCampaingsEntity>> listOfProductsByCampaign = activeCampaigns.stream().map(ProductEntity::getProductToCampaingsEntity).
					collect(Collectors.toList());				
			
			// combine the lists
			List<ProductEntity> singleList =
					listOfProductsByCampaign.stream()
							.flatMap(List::stream)
							.collect(Collectors.toList()).stream().map(ProductToCampaingsEntity::getProductEntity).collect(Collectors.toList());
			
			// filter by selected category
			singleList = singleList.stream().filter(p -> p.getCategory().equals(category)).collect(Collectors.toList());
			// sort them to make the MAX on top
			singleList.sort((o1, o2) -> o2.getPrice().compareTo(o1.getPrice()));

			returnedProduct = singleList.get(0);
		}

		return returnedProduct;
	}
}
