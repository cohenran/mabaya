package com.mabaya.sponserads.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "campaign")
public class CampaignEntity {
	@Id
	private String name;
	
	// One product can be in many campaign, and each campaign has many products = ManyToMany
	@ManyToMany
	@JoinColumn(name = "productId")
	private List<ProductEntity> productEntities;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	private Float bid;
}
