package com.ps.metals.dao;

import com.ps.metals.model.Commodity;
import com.ps.metals.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("commodityRepository")
public interface CommodityRepository extends CrudRepository<Commodity, String> {
    public Commodity findByCode(String Code);
}
