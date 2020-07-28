package com.ps.metals.service;

import com.google.common.collect.Iterables;
import com.ps.metals.RedDataTestBase;
import com.ps.metals.dao.CommodityRepository;
import com.ps.metals.dao.CounterPartyRepository;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.CounterParty;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CounterPartyDataServiceTest extends RedDataTestBase {
    @MockBean
    private CounterPartyRepository repository;

    @Autowired
    private CounterPartyDataService service;

    @Test
    public void shouldGetAllTheData() {
        List<CounterParty> data = counterPartyData();
        Mockito.when(repository.findAll()).thenReturn(Iterables.concat(data));

        List<CounterParty> refData = service.getRefData();

        MatcherAssert.assertThat(refData, Matchers.containsInAnyOrder(data.get(0), data.get(1)));
    }

    @Test
    public void shouldGetDataByCode() {
        CounterParty counterParty = new CounterParty("c1", "commodity1");
        Mockito.when(repository.findByCode("c1")).thenReturn(counterParty);

        Optional<CounterParty> refData = service.getByCode("c1");

        MatcherAssert.assertThat(refData.get(), Matchers.equalTo(counterParty));
    }

    @Test
    public void shouldRetuenNullableOptionalIfEntityNotFound() {
        Mockito.when(repository.findByCode("c1")).thenReturn(null);

        Optional<CounterParty> refData = service.getByCode("c1");

        MatcherAssert.assertThat(refData.isPresent(), Matchers.equalTo(false));
    }

}