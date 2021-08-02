package com.mabaya.sponserads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	private String title;
	private CategoryEntity category;
	private Float price;
	private int productSerial;	
}
