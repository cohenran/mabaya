package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "campaign")
public class CampaignEntity {
	@Id
	@ToString.Include
	@EqualsAndHashCode.Include
	private String name;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;

	@ToString.Include
	@EqualsAndHashCode.Include
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;

	@ToString.Include
	@EqualsAndHashCode.Include
	private Float bid;

	public CampaignEntity(String name) {
		this.name = name;
	}
}
