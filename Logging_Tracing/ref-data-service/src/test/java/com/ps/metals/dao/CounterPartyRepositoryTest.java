package com.ps.metals.dao;

import com.google.common.collect.Lists;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.CounterParty;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CounterPartyRepositoryTest {

    @Autowired
    private CounterPartyRepository repository;

    @Test
    public void shouldGetAll() {
        Iterable<CounterParty> data = repository.findAll();

        MatcherAssert.assertThat(Lists.newArrayList(data).size(), Matchers.equalTo(3));
    }

    @Test
    public void shouldGetByCode() {
        CounterParty data = repository.findByCode("ASX");

        MatcherAssert.assertThat(data, Matchers.samePropertyValuesAs(new CounterParty("ASX", "ASX Clear")));
    }
}