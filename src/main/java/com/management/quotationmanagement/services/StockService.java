package com.management.quotationmanagement.services;

import java.util.List;

import com.management.quotationmanagement.entities.Stock;

public interface StockService {

	public List<Stock> findAll();
	public Stock find(String id);
	public Stock insert(Stock stock);
	public Stock update(String id, Stock stock);
	public void delete(String id);
}
