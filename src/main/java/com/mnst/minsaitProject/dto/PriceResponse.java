package com.mnst.minsaitProject.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents the output body corresponding with price data of a /v1/price
 * response
 * 
 * @author tlorenzo
 *
 */
public class PriceResponse {

	/**
	 * Product identifier code
	 */
	private Long productId;

	/**
	 * Group brand
	 */
	private Long brandId;

	/**
	 * Applicable price rate identifier
	 */
	private Integer priceList;

	/**
	 * Application start date
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate;

	/**
	 * Application end date
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime endDate;

	/**
	 * Final price
	 */
	private Double price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, endDate, price, priceList, productId, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceResponse other = (PriceResponse) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(price, other.price) && Objects.equals(priceList, other.priceList)
				&& Objects.equals(productId, other.productId) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "PriceResponse [productId=" + productId + ", brandId=" + brandId + ", priceList=" + priceList
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + "]";
	}

}
