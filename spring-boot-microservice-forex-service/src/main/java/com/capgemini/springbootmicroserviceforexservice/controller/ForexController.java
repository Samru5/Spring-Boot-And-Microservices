package com.capgemini.springbootmicroserviceforexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springbootmicroserviceforexservice.dao.ExchangeValueDao;
import com.capgemini.springbootmicroserviceforexservice.entity.ExchangeValue;

@RestController
public class ForexController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueDao repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
		
	}
}

