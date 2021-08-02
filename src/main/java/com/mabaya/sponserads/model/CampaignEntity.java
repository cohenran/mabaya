package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

	//@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL)
	private List<ProductToCampaingsEntity> productToCampaingsEntity;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	private Float bid;

	@Override
	public String toString() {
		return "ProductToCampaingsEntity{" +
				"name=" + name +
				'}';
	}
}
