package com.ps.metals.service;

import com.google.common.collect.Iterables;
import com.ps.metals.RedDataTestBase;
import com.ps.metals.dao.CommodityRepository;
import com.ps.metals.dao.LocationRepository;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.Location;
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
class LocationDataServiceTest extends RedDataTestBase {
    @MockBean
    private LocationRepository repository;

    @Autowired
    private LocationDataService service;

    @Test
    public void shouldGetAllTheData(){
        List<Location> data = locationData();
        Mockito.when(repository.findAll()).thenReturn(Iterables.concat(data));

        List<Location> refData = service.getRefData();

        MatcherAssert.assertThat(refData, Matchers.containsInAnyOrder(data.get(0), data.get(1)));
    }

    @Test
    public void shouldGetDataByCode(){
        Location location = new Location("l1", "location1");
        Mockito.when(repository.findByCode("l1")).thenReturn(location);

        Optional<Location> refData = service.getByCode("l1");

        MatcherAssert.assertThat(refData.get(), Matchers.equalTo(location));
    }

    @Test
    public void shouldRetuenNullableOptionalIfEntityNotFound(){
        Mockito.when(repository.findByCode("l1")).thenReturn(null);

        Optional<Location> refData = service.getByCode("l1");

        MatcherAssert.assertThat(refData.isPresent(), Matchers.equalTo(false));
    }

}