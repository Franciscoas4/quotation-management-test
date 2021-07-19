package com.management.quotationmanagement.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.management.quotationmanagement.entities.Stock;
import com.management.quotationmanagement.services.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll() {
		List<Stock> stocks = this.stockService.findAll();
		return ResponseEntity.ok().body(stocks);
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> find(@PathVariable(value = "id") String id) {
		Stock stock = this.stockService.find(id);
		return ResponseEntity.ok().body(stock);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> create(@Valid @RequestBody Stock stock, Errors errors) {
		if (!errors.hasErrors()) {
			Stock stockCreated = this.stockService.insert(stock);

			return new ResponseEntity<Stock>(stockCreated, HttpStatus.CREATED);
		}

		return ResponseEntity.badRequest().body(
				errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));
	}

	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable(value = "id") String id, @RequestBody Stock stock, Errors errors) {
		if (!errors.hasErrors()) {
			Stock stockUpdated = this.stockService.update(id, stock);
			return new ResponseEntity<Stock>(stockUpdated, HttpStatus.OK);
		}

		return ResponseEntity.badRequest().body(
				errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));

	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") String id) {
		this.stockService.delete(id);
	}
}
