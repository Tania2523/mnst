package com.mnst.minsaitProject.mapper;

import org.springframework.stereotype.Component;

import com.mnst.minsaitProject.dto.PriceResponse;
import com.mnst.minsaitProject.model.Price;

/**
 * Mapper to convert {@link Price} to {@link PriceResponse}
 *
 * @author tlorenzo
 *
 */
@Component
public class PriceMapper {

	
	/**
	 * Convert {@link Price} to {@link PriceResponse}
	 * 
	 * @param price the {@link Price}
	 * @return {@link PriceResponse}
	 */
	public PriceResponse mapFromEntity(Price price) {
		PriceResponse priceResponse = new PriceResponse();

		priceResponse.setBrandId(price.getBrandId());
		priceResponse.setPrice(price.getPriceValue());
		priceResponse.setProductId(price.getProductId());
		priceResponse.setPriceList(price.getPriceList());
		priceResponse.setStartDate(price.getStartDate());
		priceResponse.setEndDate(price.getEndDate());

		return priceResponse;
	}
}
