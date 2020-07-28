package com.ps.metals.dao;

import com.ps.metals.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("locationRepository")
public interface LocationRepository extends CrudRepository<Location, String> {
    public Location findByCode(String Code);
}
