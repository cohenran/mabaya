package com.mabaya.sponserads.dao;

import com.mabaya.sponserads.model.ProductEntity;
import com.mabaya.sponserads.model.ProductToCampaingsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToCampaingsRepository  extends CrudRepository<ProductToCampaingsEntity, Integer> {
}
