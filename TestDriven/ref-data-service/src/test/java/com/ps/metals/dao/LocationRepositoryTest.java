package com.ps.metals.dao;

import com.google.common.collect.Lists;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.Location;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class LocationRepositoryTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void shouldGetALll() {
        Iterable<Location> data = repository.findAll();

        MatcherAssert.assertThat(Lists.newArrayList(data).size(), Matchers.equalTo(7));
    }

    @Test
    public void shouldGetByCode() {
        Location data = repository.findByCode("FL");

        MatcherAssert.assertThat(data, Matchers.samePropertyValuesAs(new Location("FL", "Florida")));
    }
}