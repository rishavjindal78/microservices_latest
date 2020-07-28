package com.ps.metals.dao;

import com.ps.metals.model.CounterParty;
import com.ps.metals.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("counterPartyRepository")
public interface CounterPartyRepository extends CrudRepository<CounterParty, String> {
    public CounterParty findByCode(String Code);
}
