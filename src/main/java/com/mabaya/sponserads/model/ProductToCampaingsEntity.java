package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products_to_campaigns")
public class ProductToCampaingsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JsonBackReference
	@JsonIgnoreProperties
	@JoinColumn(name = "productId")
	private ProductEntity productEntity;

	@NonNull
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "name")
	private CampaignEntity campaignEntity;

	@Override
	public String toString() {
		return "ProductToCampaingsEntity{" +
				"id=" + id +
				", productEntity=" + productEntity.getId() +
				", campaignEntity=" + campaignEntity.getName() +
				'}';
	}
}
