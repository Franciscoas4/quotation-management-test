package com.management.quotationmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.quotationmanagement.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, String>{
	
}
