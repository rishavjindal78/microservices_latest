package com.ps.metals.service;

import com.google.common.collect.Iterables;
import com.ps.metals.RedDataTestBase;
import com.ps.metals.dao.CommodityRepository;
import com.ps.metals.model.Commodity;
import org.assertj.core.api.Assert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class CommodityDataServiceTest extends RedDataTestBase {
    @MockBean
    private CommodityRepository repository;

    @Autowired
    private CommodityDataService service;

    @Test
    public void shouldGetAllTheData(){
        List<Commodity> data = commodityData();
        when(repository.findAll()).thenReturn(Iterables.concat(data));

        List<Commodity> refData = service.getRefData();

        assertThat(refData, Matchers.containsInAnyOrder(data.get(0), data.get(1)));
    }

    @Test
    public void shouldGetDataByCode(){
        Commodity commodity = new Commodity("c1", "commodity1");
        when(repository.findByCode("c1")).thenReturn(commodity);

        Optional<Commodity> refData = service.getByCode("c1");

        assertThat(refData.get(), Matchers.equalTo(commodity));
    }

    @Test
    public void shouldRetuenNullableOptionalIfEntityNotFound(){
        Commodity commodity = new Commodity("c1", "commodity1");
        when(repository.findByCode("c1")).thenReturn(null);

        Optional<Commodity> refData = service.getByCode("c1");

        assertThat(refData.isPresent(), Matchers.equalTo(false));
    }

}