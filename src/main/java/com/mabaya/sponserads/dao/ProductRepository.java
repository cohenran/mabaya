package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
	List<ProductEntity> findAll();

	@Query(value = "SELECT * FROM product " +
			"WHERE id IN :id", nativeQuery = true)
	List<ProductEntity> getById(@Param(value = "id") List<Integer> id);

	List<ProductEntity> findByCategory(String category);

	/**
	 * @return A single one with the highest price
	 */
	@Query(value = "SELECT * " +
			"FROM product " +
			"GROUP BY price " +
			"ORDER BY price desc " +
			"LIMIT 1", nativeQuery = true)
	ProductEntity getHighestBid();

	@Query(value =
			"SELECT * FROM " +
					"product product INNER JOIN products_to_campaigns products_to_campaigns " +
					"ON product.id = products_to_campaigns.id INNER JOIN campaign campaign " +
					"ON campaign.name = products_to_campaigns.name " +
					"WHERE product.category = :category", nativeQuery = true)
	List<ProductEntity> getCampaignsByProductCategory(@Param("category") String category);

	@Query(value =
			"SELECT * FROM " +
					"product product INNER JOIN products_to_campaigns products_to_campaigns " +
					"ON product.id = products_to_campaigns.id INNER JOIN campaign campaign " +
					"ON campaign.name = products_to_campaigns.name " +
					"WHERE product.category = :category " +
					"GROUP BY price " +
					"ORDER BY price desc " +
					"LIMIT 1", nativeQuery = true)
	Optional<ProductEntity> getHighestBidWithActiveCampaign(@Param("category") String category);
}
