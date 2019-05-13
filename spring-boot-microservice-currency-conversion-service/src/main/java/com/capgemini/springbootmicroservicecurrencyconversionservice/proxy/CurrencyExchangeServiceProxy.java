package com.capgemini.springbootmicroservicecurrencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.springbootmicroservicecurrencyconversionservice.model.CurrencyConversion;


@FeignClient(name="forex-service")
@RibbonClient(name="forex-service")

public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyConversion retrieveExchangeValue
	    (@PathVariable("from") String from, @PathVariable("to") String to);
}

