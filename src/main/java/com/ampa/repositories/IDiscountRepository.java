package com.ampa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ampa.models.Discount;

@Repository
public interface IDiscountRepository extends CrudRepository<Discount, Long> {

	@Query(nativeQuery = true, value = "Select * from discounts where discounts.idDiscount = ?")
	Discount findDiscount(Long idDiscount);
	
	List<Discount> findByTitular(String discountTitular);

}
