package com.mabaya.sponserads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
	private List<ProductEntity> productEntities;
	private LocalDate startDate;
	private Float bid;
}
