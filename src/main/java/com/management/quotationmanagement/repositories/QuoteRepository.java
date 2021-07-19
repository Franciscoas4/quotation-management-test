package com.management.quotationmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.quotationmanagement.entities.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long>{

}
