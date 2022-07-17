package com.risiellesantos.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.risiellesantos.dsmeta.entities.Sales;
import com.risiellesantos.dsmeta.services.SalesService;
import com.risiellesantos.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {
	
	@Autowired
	private SalesService service;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sales> findSales(
			@RequestParam(value = "minDate", defaultValue = "")String minDate,
			@RequestParam(value = "maxDate", defaultValue = "")String maxDate,
			Pageable pageable){
		return service.findSales(minDate, maxDate, pageable);		
		
	}
	
	@GetMapping("/{id}/notification") //o entre chaves é o parametro que vai passar
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
