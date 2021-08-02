package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.CampaignEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<CampaignEntity, Integer> {
	List<CampaignEntity> findByName(String name);
}