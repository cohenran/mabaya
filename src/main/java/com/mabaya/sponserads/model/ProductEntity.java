package com.mabaya.sponserads.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue
	private Integer id;
	@NonNull
	private String category;
	@NonNull
	private String title;
	@NonNull
	private Float price;
	@NonNull
	private String productSerial;	
}
