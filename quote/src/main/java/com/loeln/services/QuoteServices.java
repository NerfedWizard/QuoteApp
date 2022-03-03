package com.loeln.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loeln.quoteapp.Quote;
import com.loeln.repository.QuoteRepo;

@Service
public class QuoteServices {

	@Autowired
	private QuoteRepo quoteRepo;

	public QuoteServices(QuoteRepo quoteRepo) {
//		quoteRepo.useTable();
		this.quoteRepo = quoteRepo;
	}

	public List<Quote> getQuotes() {
//		quoteRepo.useTable();
		return quoteRepo.findAll();
	}

	public List<Quote> findQuoteByCategory(String category) {

		return quoteRepo.findByQuoteCategory(category.toLowerCase());
	}

	public List<Quote> findQuoteByPopularity(Double popularity) {

		return quoteRepo.findByQuotePopularity(popularity);
	}

	public List<Quote> findQuoteByAuthor(String author) {

		return quoteRepo.findByQuoteCategory(author);
	}

	public Quote findQuoteById(String quoteId) {

		return quoteRepo.findByQuoteId(quoteId);
	}

}
