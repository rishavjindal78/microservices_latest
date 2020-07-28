package com.ps.metals.controller;

import com.ps.metals.RedDataTestBase;
import com.ps.metals.model.Commodity;
import com.ps.metals.model.CounterParty;
import com.ps.metals.model.Location;
import com.ps.metals.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.apache.http.client.methods.RequestBuilder.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RefDataController.class)
class RefDataControllerTest extends RedDataTestBase {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "locationDataService")
    private LocationDataService locationDataService;

    @MockBean(name = "counterPartyDataService")
    private CounterPartyDataService counterPartyDataService;

    @MockBean(name = "commodityDataService")
    private CommodityDataService commodityDataService;

    @InjectMocks
    private RefDataController controller;

    @Test
    public void shouldReturnAllTheLocations() throws Exception {
        Mockito.when(locationDataService.getRefData()).thenReturn(locationData());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/location"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":[{\"code\":\"l1\",\"name\":\"location1\"},{\"code\":\"l2\",\"name\":\"location2\"}],\"errorMessage\":null}"))
                .andReturn();

    }

    @Test
    public void shouldReturnAllTheCounterParty() throws Exception {
        Mockito.when(counterPartyDataService.getRefData()).thenReturn(counterPartyData());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/counterParty"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":[{\"code\":\"cp1\",\"name\":\"counter party 1\"},{\"code\":\"cp2\",\"name\":\"counter party 2\"}],\"errorMessage\":null}"))
                .andReturn();

    }

    @Test
    public void shouldReturnAllTheCommodities() throws Exception {
        Mockito.when(commodityDataService.getRefData()).thenReturn(commodityData());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/commodity"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":[{\"code\":\"c1\",\"name\":\"commodity1\"},{\"code\":\"c2\",\"name\":\"commodity2\"}],\"errorMessage\":null}"))
                .andReturn();

    }

    @Test
    public void shouldReturnALocationByCode() throws Exception {
        Mockito.when(locationDataService.getByCode("l1")).thenReturn(Optional.of(new Location("l1", "location1")));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/location/l1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":{\"code\":\"l1\",\"name\":\"location1\"},\"errorMessage\":null}"))
                .andReturn();

    }

    @Test
    public void shouldReturnACounterPartyByCode() throws Exception {
        Mockito.when(counterPartyDataService.getByCode("cp1")).thenReturn(Optional.of(new CounterParty("cp1", "counter party 1")));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/counterParty/cp1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":{\"code\":\"cp1\",\"name\":\"counter party 1\"},\"errorMessage\":null}"))
                .andReturn();

    }

    @Test
    public void shouldReturnACommodityByCode() throws Exception {
        Mockito.when(commodityDataService.getByCode("c1")).thenReturn(Optional.of(new Commodity("c1", "commodity1")));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/commodity/c1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true,\"failure\":null,\"data\":{\"code\":\"c1\",\"name\":\"commodity1\"},\"errorMessage\":null}"))
                .andReturn();
    }

    @Test
    public void shouldReturnErrorMessageIfCommodityNotFoundByCode() throws Exception {
        Mockito.when(commodityDataService.getByCode("c1")).thenReturn(Optional.ofNullable(null));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/commodity/c1"))
                .andExpect(status().is(404))
                .andExpect(content().json("{\"success\":null,\"failure\":true,\"data\":null,\"errorMessage\":\"commodity not found for code c1\"}"))
                .andReturn();
    }

    @Test
    public void shouldReturnErrorMessageIflocationNotFoundByCode() throws Exception {
        Mockito.when(commodityDataService.getByCode("c1")).thenReturn(Optional.ofNullable(null));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/location/l1"))
                .andExpect(status().is(404))
                .andExpect(content().json("{\"success\":null,\"failure\":true,\"data\":null,\"errorMessage\":\"location not found for code l1\"}"))
                .andReturn();
    }

    @Test
    public void shouldReturnErrorMessageIfRefDataEntityIsNotSupported() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/unkown"))
                .andExpect(status().is(400))
                .andExpect(content().json("{\"success\":null,\"failure\":true,\"data\":null,\"errorMessage\":\"Reference data type - unkown is not supported\"}"))
                .andReturn();
    }

    @Test
    public void shouldReturnErrorMessageIfCounterPartyNotFoundByCode() throws Exception {
        Mockito.when(commodityDataService.getByCode("c1")).thenReturn(Optional.ofNullable(null));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/refdata/counterParty/cp1"))
                .andExpect(status().is(404))
                .andExpect(content().json("{\"success\":null,\"failure\":true,\"data\":null,\"errorMessage\":\"counterParty not found for code cp1\"}"))
                .andReturn();
    }


}