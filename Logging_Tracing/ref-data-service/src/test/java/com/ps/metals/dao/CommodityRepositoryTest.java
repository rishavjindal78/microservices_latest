package com.ps.metals.dao;

import com.google.common.collect.Lists;
import com.ps.metals.model.Commodity;
import org.assertj.core.matcher.AssertionMatcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommodityRepositoryTest {

    @Autowired
    private CommodityRepository repository;

    @Test
    public void shouldGetAll() {
        Iterable<Commodity> data = repository.findAll();

        MatcherAssert.assertThat(Lists.newArrayList(data).size(), Matchers.equalTo(9));
    }

    @Test
    public void shouldGetByCode() {
        Commodity data = repository.findByCode("CPO");

        MatcherAssert.assertThat(data, Matchers.samePropertyValuesAs(new Commodity("CPO", "Cpo")));
    }
}