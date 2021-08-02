package com.mabaya.sponserads.controller;

import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AdsController {
	@Autowired
	private AdService adService;
	
	@PostMapping("createCampaign")
	public ResponseEntity<CampaignEntity> createCampaign(@RequestParam String name, @RequestBody CampaignEntity campaignEntity) {
		CampaignEntity savedCampaignEntity = adService.createCampaign(name, campaignEntity);

		return new ResponseEntity<>(savedCampaignEntity, HttpStatus.OK);
	}
	
	@GetMapping("serveAd")
	public ProductEntity serveAd(@RequestParam String category) {
		return null;
	}
}
