package com.mabaya.sponserads.controller;

import com.mabaya.sponserads.dao.CampaignRepository;
import com.mabaya.sponserads.dao.ProductRepositpry;
import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("v1/manage")
public class AdsController {
	@Autowired
	private AdService adService;

	@Resource
	private CampaignRepository campaignRepository;
	@Resource
	private ProductRepositpry productRepositpry;

	@PostMapping("createCampaign")
	public ResponseEntity<CampaignEntity> createCampaign(@RequestParam String name, @RequestBody CampaignEntity campaignEntity) {
		CampaignEntity savedCampaignEntity = adService.createCampaign(name, campaignEntity);

		return new ResponseEntity<>(savedCampaignEntity, HttpStatus.OK);
	}

	@GetMapping("serveAd")
	public @ResponseBody ProductEntity serveAd(@RequestParam String category) {
		ProductEntity productEntity = adService.serveAd(category);

		return productEntity;
	}

	// FOR DEBUG PURPOSES ONLY - CAN BE DELETED
	@GetMapping(value = "/showCampaigns", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<CampaignEntity> showCampaigns() {
		return campaignRepository.findAll();
	}

	// FOR DEBUG PURPOSES ONLY - CAN BE DELETED
	@GetMapping(value = "/showProducts", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<ProductEntity> showProducts() {
		return productRepositpry.findAll();
	}
}
