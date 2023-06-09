package com.mnst.minsaitProject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mnst.minsaitProject.model.Price;

/**
 * JPA repository for {@link Price} database entity.
 * 
 * @author tlorenzo
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

    @Query(nativeQuery = false,
    value = ""
            + "SELECT p " +
			   "FROM Price p " +
		       "WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
			   "AND p.productId = :productId " +
		       "AND p.brandId = :brandId " )
	List<Price> findPrices(@Param("applicationDate") LocalDateTime applicationDate, @Param("productId") Long productId, @Param("brandId") Long brandId);
}
