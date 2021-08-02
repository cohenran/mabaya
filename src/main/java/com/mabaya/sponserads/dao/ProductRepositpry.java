package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.CampaignEntity;
import com.mabaya.sponserads.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositpry extends CrudRepository<ProductEntity, Integer> {
	List<ProductEntity> findAll();
	
	List<ProductEntity> findByCategory(String category);
	
	@Query(value = "SELECT MAX(bid) FROM products", nativeQuery = true)
	ProductEntity getHighestBid();
}
