package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.CampaignEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<CampaignEntity, Integer> {
	List<CampaignEntity> findAll();

	CampaignEntity findByName(String name);

	// add 365 times year difference to make up dates like 05-01-2022
	@Query(value = "SELECT * FROM campaign where " +
			"(YEAR(CURRENT_DATE()) - YEAR(start_date)) * 365 + DAYOFYEAR(CURRENT_DATE()) - DAYOFYEAR(start_date) < 10", nativeQuery = true)
	List<CampaignEntity> getActiveCampaigns();

	@Query(value =
			"SELECT * FROM " +
					"campaign campaign INNER JOIN products_to_campaigns products_to_campaigns " +
					"ON campaign.name = products_to_campaigns.name INNER JOIN product product " +
					"ON product.id = products_to_campaigns.id " +
					"WHERE product.category = :category", nativeQuery = true)
	List<CampaignEntity> getCampaignsByProductCategory(@Param("category") String category);
}
