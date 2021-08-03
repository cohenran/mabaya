package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "products_to_campaigns")
public class ProductToCampaingsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	@JoinColumn(name = "product_id")
	private ProductEntity productEntity;

	@ManyToOne
	@JsonIgnoreProperties
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

	public ProductToCampaingsEntity(@NonNull ProductEntity productEntity, CampaignEntity campaignEntity) {
		this.productEntity = productEntity;
		this.campaignEntity = campaignEntity;
	}
}
