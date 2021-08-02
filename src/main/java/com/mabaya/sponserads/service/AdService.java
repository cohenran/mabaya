package com.mabaya.sponserads.service;

import com.mabaya.sponserads.model.CampaignEntity;

public interface AdService {
	CampaignEntity createCampaign(String name, CampaignEntity campaignEntity);
}
