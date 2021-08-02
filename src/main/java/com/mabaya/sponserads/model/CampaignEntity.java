package com.mabaya.sponserads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CampaignEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	@OneToMany
	private List<ProductEntity> productEntities;
	private LocalDate startDate;
	private Float bid;
}
