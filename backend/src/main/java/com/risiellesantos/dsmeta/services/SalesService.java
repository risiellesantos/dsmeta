package com.risiellesantos.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risiellesantos.dsmeta.entities.Sales;
import com.risiellesantos.dsmeta.repositories.SalesRepository;


@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	public List<Sales> findSales() {
		return repository.findAll();
	}

}
