package com.ps.metals.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ps.metals.dao.CommodityRepository;
import com.ps.metals.model.Commodity;

@Service("commodityDataService")
public class CommodityDataService implements RefDataService<Commodity> {

    private final CommodityRepository repository;
    
    private static final Logger log = LoggerFactory.getLogger(CommodityDataService.class);

    @Autowired
    public CommodityDataService(CommodityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Commodity> getRefData() {
    	log.info("CommodityDataService getRefData");
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Optional<Commodity> getByCode(String code) {
    	log.info("CommodityDataService getByCode {}",code);

        Commodity commodity = repository.findByCode(code);
        return Optional.ofNullable(commodity);
    }
}
