package com.ampa.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ampa.models.Discount;
import com.ampa.repositories.IDiscountRepository;
import com.ampa.services.IDiscountService;

@Component
public class DiscountHandler implements IDiscountService {
	
	@Autowired
	IDiscountRepository discountRepository;

	@Override
	public List<Discount> findAll() {
		return (List<Discount>) discountRepository.findAll();
	}

	@Override
	public Discount findById(Long idDiscount) {
		return discountRepository.findDiscount(idDiscount);
	}

	@Override
	public List<Discount> findByTitular(String discountTitular) {
		return discountRepository.findByTitular(discountTitular);
	}

	@Override
	public Discount saveDiscount(Discount discountAux) {
		
		Discount discount = findById(discountAux.getIdDiscount());
		if(discount == null || discountAux.getIdDiscount() == 0) {
			discount = new Discount();
			discount.setImage(null);
			discount.setText(discountAux.getText());
			discount.setTitular(discountAux.getTitular());
			discount.setAmpa(discountAux.getAmpa());
			discountAux = discountRepository.save(discount);
			
		}else {
			if (discount != null) {
				discountAux = discountRepository.save(discountAux);
			}
		}
		return discountAux;
	}

	@Override
	public void deleteDiscount(Long idDiscount) {
		Discount discountAux = findById(idDiscount);
		if (discountAux != null)   discountRepository.delete(discountAux);
	}

}
