package com.ampa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ampa.handlers.DiscountHandler;
import com.ampa.models.Discount;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/discounts")
@Tag(name = "Mantenimiento descuentos")
@CrossOrigin
public class DiscountController {
	

	@Autowired
	DiscountHandler discountHandler;
	
	@Operation(summary = "Listado de descuentos", description = "Listado de descuentos")
	@GetMapping("/discount")
	public List<Discount> getAllDiscounts(){
		return discountHandler.findAll();
	}
	
	@Operation(summary = "Detalle descuento", description = "Detalle descuento")
	@GetMapping("/discounts-byid")
	public Discount findAllById(@RequestParam("idDiscount") Long idDiscount){
		return discountHandler.findById(idDiscount);
	}
	
	@Transactional
	@Operation(summary = "Alta/Modificación de un descuento", description = "Alta/Modificación de un descuento")
	@PostMapping("/discount")
	public Discount saveDiscount(@RequestBody Discount discountAux) {
		return discountHandler.saveDiscount(discountAux);
	}
	
	@Transactional
	@Operation(summary = "Borrar un descuento", description = "Borrar un descuento")
	@DeleteMapping("/delete-discount/{idDiscount}")
	public void deleteDiscount(@PathVariable("idDiscount") Long  idDiscount) {
		discountHandler.deleteDiscount(idDiscount);
	}

}
