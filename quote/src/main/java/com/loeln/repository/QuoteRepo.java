package com.loeln.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.loeln.quoteapp.Quote;

@Repository
public interface QuoteRepo extends CrudRepository<Quote, Long> {

	@Modifying
	@Transactional
	@Query(value = "insert into ")
	public void loadDataIntoTable(String author, String quote, String category, Double popularity);

	Quote findByQuoteId(String quoteId);

	List<Quote> findByQuoteCategory(String category);

	List<Quote> findByQuoteAuthor(String author);

	List<Quote> findByQuotePopularity(Double popularity);

	@Override
	List<Quote> findAll();
}
