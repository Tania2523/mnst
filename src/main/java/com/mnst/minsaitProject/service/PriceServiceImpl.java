package com.mnst.minsaitProject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mnst.minsaitProject.model.Price;
import com.mnst.minsaitProject.repository.PriceRepository;
import java.util.ArrayList;

import lombok.AllArgsConstructor;

/**
 * Service to obtain prices
 * 
 * @author tlorenzo
 *
 */
@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository repository;

	/**
	 * Get the prices according to the parameters
	 * 
	 * @param applicationDate the application date to find the prices
	 * @param productId       the product ID to find the prices
	 * @param brandId         the brand ID to find the prices
	 * @return the list of {@link Prices} obtained
	 */
	@Override
	public List<Price> getPrices(LocalDateTime applicationDate, Long productId, Long brandId) {
		List<Price> priceList = repository.findPrices(applicationDate, productId, brandId);

		if (priceList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No price found for the specified request.");
		}

		return filterPricesByFareAndPriority(priceList);
	}

	/**
	 * Filter the list of the prices depending of the fare and according with the
	 * priority If two or more prices have the same fare, check the priority and
	 * choose the higher value. If two or more prices have the same fare and the
	 * same priority, return all of them.
	 *
	 * @param priceList the prices obtained
	 * @return the list of prices
	 */
	private List<Price> filterPricesByFareAndPriority(List<Price> priceList) {
		Map<Integer, List<Price>> pricesMap = priceList.stream().collect(Collectors.groupingBy(Price::getPriceList));
		List<Price> pricesFiltered = new ArrayList<>();

		for (Integer priceListKey : pricesMap.keySet()) {
			List<Price> prices = pricesMap.get(priceListKey);

			if (prices.size() == 1) {
				pricesFiltered.add(prices.get(0));
			} else {
				int maxPriority = prices.stream().mapToInt(Price::getPriority).max().orElse(0);

				List<Price> pricesMaxPriority = prices.stream().filter(price -> price.getPriority() == maxPriority)
						.collect(Collectors.toList());

				pricesFiltered.addAll(pricesMaxPriority);
			}
		}

		return pricesFiltered;
	}
}
