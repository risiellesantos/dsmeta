package com.risiellesantos.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.risiellesantos.dsmeta.entities.Sales;
import com.risiellesantos.dsmeta.repositories.SalesRepository;


@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());//criar uma data com o dia de "hoje"
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);// se não a data de um ano atras
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate); //condição de se não for informado coloca a data today, se não é a data passada (valor na frente da ? é o verdadeiro, valor na frente do : é o falso 
		
		return repository.findSales(min, max ,pageable);
	}

}
