package com.loeln.quoteapp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "quote")
	private String quote;
	@Column(name = "auhtor")
	private String author;
	@Column(name = "popularity")
	private Double popularity = 0.0;
	@Column(name = "catergory")
	private String category = null;

}