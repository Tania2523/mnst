package com.mnst.minsaitProject.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

	/**
	 * Identifier of the Price data
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Group brand ID
	 */
	@Column(name = "brand_id", nullable = false)
	private Long brandId;
	
	/**
	 * Application start date
	 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	@Column(name = "start_date")
	private LocalDateTime startDate;

	/**
	 * Application end date
	 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	@Column(name = "end_date")
	private LocalDateTime endDate;

	/**
	 * Applicable price rate identifier
	 */
	@Column(name = "price_list")
	private Integer priceList;

	/**
	 * Product identifier code
	 */
	@Column(name = "product_id")
	private Long productId;

	/**
	 * Price application disambiguator
	 */
	@Column(name = "priority")
	private Integer priority;

	/**
	 * Final price
	 */
	@Column(name = "price_value")
	private Double priceValue;

	/**
	 * Currency
	 */
	@Column(name = "curr")
	private String currency;
}
