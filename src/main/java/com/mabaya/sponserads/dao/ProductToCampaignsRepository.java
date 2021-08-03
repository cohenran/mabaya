package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductToCampaignsRepository extends CrudRepository<ProductToCampaingsEntity, Integer> {
	@Query(value = "SELECT * FROM products_to_campaigns WHERE product_id in :productIds", nativeQuery = true)
	List<ProductToCampaingsEntity> getByProductId(@Param("productIds") List<Integer> productEntities);
}
