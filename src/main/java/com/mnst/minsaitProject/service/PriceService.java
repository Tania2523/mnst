package com.mnst.minsaitProject.service;

import java.time.LocalDateTime;
import java.util.List;

import com.mnst.minsaitProject.model.Price;

/**
 * Interface to define the allowed methods
 *
 * @author tlorenzo
 *
 */
public interface PriceService {

	/**
	 * Get the prices according with the parameters
	 * 
	 * @param applicationDate application date to find prices
	 * @param productId       the product ID of the price
	 * @param brandId         the brand ID of the price
	 * @return the {@link Price}
	 */
	List<Price> getPrices(LocalDateTime applicationDate, Long productId, Long brandId);
}
