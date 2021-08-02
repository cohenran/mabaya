package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;
	
	@NonNull
	private String category;
	@NonNull
	private String title;
	@NonNull
	private Float price;
	@NonNull
	private String productSerial;

	@Override
	public String toString() {
		return "ProductToCampaingsEntity{" +
				"id=" + id +
				'}';
	}
}
