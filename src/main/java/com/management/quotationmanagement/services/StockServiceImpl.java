package com.management.quotationmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.quotationmanagement.entities.Stock;
import com.management.quotationmanagement.repositories.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	public List<Stock> findAll() {
		return this.stockRepository.findAll();
	}

	@Override
	public Stock find(String id) {
		return findById(id);
	}

	@Override
	public Stock insert(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public Stock update(String id, Stock stock) {
		Stock existStock = findById(id);

		if (existStock != null) {
			stock.setStockId(existStock.getStockId());
			return this.stockRepository.save(stock);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		Stock stock = findById(id);

		if (stock != null) {
			this.stockRepository.delete(stock);
		}

	}

	private Stock findById(String id) {
		return this.stockRepository.findById(id).orElse(null);
	}

}
