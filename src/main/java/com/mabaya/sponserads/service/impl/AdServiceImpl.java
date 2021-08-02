package com.mabaya.sponserads.service.impl;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdServiceImpl implements AdService {
	@Resource
	private CampaignRepository campaignRepository;

	@Override
	public CampaignEntity createCampaign(String name, CampaignEntity campaignEntity) {
		campaignEntity.setName(name);

		campaignRepository.save(campaignEntity);

		return campaignEntity;
	}
}
