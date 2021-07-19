package com.management.quotationmanagement.services;

import java.util.List;

import com.management.quotationmanagement.entities.Quote;

public interface QuoteService {

	public List<Quote> findAll();
	public Quote find(Long id);
	public Quote create(Quote quote, String stockId);
	public Quote update(Long id, Quote quote);
	public void delete(Long id);
}
