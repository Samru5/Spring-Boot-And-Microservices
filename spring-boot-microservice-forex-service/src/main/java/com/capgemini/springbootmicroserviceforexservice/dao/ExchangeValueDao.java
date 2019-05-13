package com.capgemini.springbootmicroserviceforexservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springbootmicroserviceforexservice.entity.ExchangeValue;


public interface ExchangeValueDao extends JpaRepository<ExchangeValue, Long>{
	ExchangeValue findByFromAndTo(String from ,String to);
}

