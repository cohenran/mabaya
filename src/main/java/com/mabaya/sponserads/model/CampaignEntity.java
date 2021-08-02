package com.mabaya.sponserads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private List<ProductEntity> productEntities;
	private LocalDate startDate;
	private Float bid;
}
