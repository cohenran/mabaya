package com.mabaya.sponserads.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "product")
public class ProductEntity {
	@Id
	@ToString.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;
	
	@NonNull
	@ToString.Include
	@EqualsAndHashCode.Include
	private String category;
	@NonNull
	@ToString.Include
	@EqualsAndHashCode.Include
	private String title;
	@NonNull
	@ToString.Include
	@EqualsAndHashCode.Include
	private Float price;
	@NonNull
	@ToString.Include
	@EqualsAndHashCode.Include
	private String productSerial;

/*	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProductEntity that = (ProductEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(category, that.category) &&
				Objects.equals(title, that.title) &&
				Objects.equals(price, that.price) &&
				Objects.equals(productSerial, that.productSerial);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productToCampaingsEntity, category, title, price, productSerial);
	}*/
}
