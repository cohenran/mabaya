package com.mabaya.sponserads.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
