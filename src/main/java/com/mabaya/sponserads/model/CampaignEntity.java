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
	private String name;

//	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;

	@EqualsAndHashCode.Include
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@EqualsAndHashCode.Include
	private Float bid;

	public CampaignEntity(String name) {
		this.name = name;
	}
}
