package com.mnst.minsaitProject.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mnst.minsaitProject.dto.PriceResponse;
import com.mnst.minsaitProject.mapper.PriceMapper;
import com.mnst.minsaitProject.model.Price;
import com.mnst.minsaitProject.service.PriceService;

import lombok.RequiredArgsConstructor;

/**
 * Controller for allowed operations in the /price context
 *
 * @author tlorenzo
 */
@RestController
@RequestMapping(path = "/v1/price", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PriceController {

	@Autowired
	private PriceService service;

	@Autowired
	private PriceMapper mapper;

	/**
	 * Get prices according to the parameters
	 * 
	 * @param applicationDate the application date
	 * @param productId       the product ID
	 * @param brandId         the branch ID
	 * @return list of {@link PriceResponse} containing the information about the
	 *         prices
	 */
	@GetMapping
	public ResponseEntity<List<PriceResponse>> getPrice(
			@RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime applicationDate,
			@RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {
		List<Price> priceList = service.getPrices(applicationDate, productId, brandId);

		List<PriceResponse> priceResponseList = new ArrayList<>();

		for (Price price : priceList) {
			priceResponseList.add(mapper.mapFromEntity(price));
		}

		return new ResponseEntity<List<PriceResponse>>(priceResponseList, HttpStatus.OK);
	}

}
