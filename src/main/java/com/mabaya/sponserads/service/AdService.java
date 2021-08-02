package com.mabaya.sponserads.service;

import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;

public interface AdService {
	CampaignEntity createCampaign(String name, CampaignEntity campaignEntity);

	ProductEntity serveAd(String category);
}
