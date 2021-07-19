package com.management.quotationmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.quotationmanagement.entities.Quote;
import com.management.quotationmanagement.entities.Stock;
import com.management.quotationmanagement.repositories.QuoteRepository;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository quoteRepository;

	@Autowired
	private StockService stockService;

	@Override
	public List<Quote> findAll() {
		return this.quoteRepository.findAll();
	}

	@Override
	public Quote find(Long id) {
		return findById(id);
	}

	@Override
	public Quote create(Quote quote, String stockId) {
		Stock stock = stockService.find(stockId);
		quote.setStock(stock);
		return this.quoteRepository.save(quote);
	}

	@Override
	public Quote update(Long id, Quote quote) {
		Quote existQuote = findById(id);

		if (existQuote != null) {
			quote.setId(existQuote.getId());
			return quoteRepository.save(quote);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Quote existQuote = findById(id);

		if (existQuote != null) {
			quoteRepository.delete(existQuote);
		}
	}

	private Quote findById(Long id) {
		return this.quoteRepository.findById(id).orElse(null);
	}

}
