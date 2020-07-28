package com.ps.metals;

import com.ps.metals.entity.Trade;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class TradingStepDefinitions extends TradingServiceApplicationTests {
	
	Trade trade;
	String url = DEFAULT_URL;
	
	@Given("The trade is already done")
	public void the_trade_is_already_done() throws Throwable {
		trade = new Trade();
	}
	
	@When("Check the tade with id {string}")
	public void check_the_tade_with_id(String id) throws Throwable {
		trade = restTemplate.getForObject(url + "trades/"+id, Trade.class);

	}
	

	@Then("The result of the trade is {string}")
	public void the_result_of_the_trade_is_sell(String side) throws Throwable{
		assertEquals(trade.getSide(), side);
	}
	
}
