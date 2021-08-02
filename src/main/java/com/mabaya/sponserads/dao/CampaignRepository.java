package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.CampaignEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<CampaignEntity, Integer> {
	List<CampaignEntity> findAll();
	
	List<CampaignEntity> findByName(String name);
	
	// add 365 times year difference to make up dates like 05-01-2022
	@Query(value = "SELECT * FROM campaign where " +
			"(YEAR(CURRENT_DATE() - YEAR(startDate)) * 365 + DAYOFYEAR(CURRENT_DATE()) - DAYOFYEAR(startDate) < 10)", nativeQuery = true)
	List<CampaignEntity> getActiveCampaigns();

	@Query(value = 
			"SELECT * from campaign INNER JOIN product " +
			"ON campaign.product.id - product.id" +
			"WHERE product.category = category", nativeQuery = true)
	List<CampaignEntity> getProductByCategory(String category);
}
