package com.loeln.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loeln.quoteapp.Quote;
import com.loeln.services.QuoteServices;

import lombok.extern.slf4j.Slf4j;

@Component
@RestController
@RequestMapping("/api/quotes")
@Slf4j
@CrossOrigin
public class QuoteController {

	@Autowired
	QuoteServices quoteService;

	@GetMapping(path = "/all")
	public List<Quote> getQuotes() {

		log.info("QuoteController: list quotes");
		System.out.println("Should be doing something");
		return quoteService.getQuotes();
	}

	@GetMapping(path = "/{author}")
	public List<Quote> getQuotesByAuthor(Quote quote) {

		log.info("QuoteController: quotes by author");

		return quoteService.findQuoteByAuthor(quote.getAuthor());
	}

	@GetMapping(path = "/{category}")
	public List<Quote> getQuotesByCategory(Quote quote) {

		log.info("QuoteController: quotes by category");

		return quoteService.findQuoteByCategory(quote.getCategory());
	}

	@GetMapping(path = "/{quoteId}")
	public ResponseEntity<?> getQuoteById(String quoteId) {

		Quote quote = quoteService.findQuoteById(quoteId);

		return new ResponseEntity<Quote>(quote, HttpStatus.OK);

	}
}
