package com.mabaya.sponserads.controller;

import com.mabaya.sponserads.model.CategoryEntity;
import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void createCampaign(@RequestParam String name, @RequestBody CategoryEntity categoryEntity) {
		
	}
	
	@GetMapping("serveAd")
	public ProductEntity serveAd(@RequestParam String category) {
		return null;
	}
}
