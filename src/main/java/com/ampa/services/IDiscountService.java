package com.ampa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ampa.models.Discount;

@Service
public interface IDiscountService {
	
	public abstract List<Discount> findAll();
	public abstract Discount findById(Long idDiscount);
	public abstract List<Discount> findByTitular(String discountTitular);
	public abstract Discount saveDiscount(Discount discountAux);
	public abstract void deleteDiscount(Long idDiscount);

}
