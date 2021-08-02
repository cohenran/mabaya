package com.mabaya.sponserads.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	private Float price;
	private int productSerial;	
}
