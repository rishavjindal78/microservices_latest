package com.ps.metals;

import com.google.common.collect.Lists;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.CounterParty;
import com.ps.metals.model.Location;

import java.util.List;

public class RedDataTestBase {
    public List<Location> locationData() {
        return Lists.newArrayList(new Location("l1", "location1"), new Location("l2", "location2"));
    }

    public List<CounterParty> counterPartyData() {
        return Lists.newArrayList(new CounterParty("cp1", "counter party 1"), new CounterParty("cp2", "counter party 2"));
    }

    public List<Commodity> commodityData() {
        return Lists.newArrayList(new Commodity("c1", "commodity1"), new Commodity("c2", "commodity2"));
    }

}
