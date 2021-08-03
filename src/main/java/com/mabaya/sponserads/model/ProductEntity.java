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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;
	
	@NonNull
	@EqualsAndHashCode.Include
	private String category;
	@NonNull
	@EqualsAndHashCode.Include
	private String title;
	@NonNull
	@EqualsAndHashCode.Include
	private Float price;
	@NonNull
	@EqualsAndHashCode.Include
	private String productSerial;

	@Override
	public String toString() {
		return "ProductToCampaingsEntity{" +
				"id=" + id +
				'}';
	}

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
