package com.ps.metals.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ps.metals.entity.Trade;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String> {

	public Optional<Trade> findById(String id);
}
