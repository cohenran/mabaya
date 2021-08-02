package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
	List<ProductEntity> findAll();
	
	List<ProductEntity> findByCategory(String category);

	/**
	 * 
	 * @return A single one with the highest price
	 */
	@Query(value = "SELECT * " +
			"FROM product " +
			"GROUP BY price " +
			"ORDER BY price desc " +
			"LIMIT 1", nativeQuery = true)
	ProductEntity getHighestBid();
}
