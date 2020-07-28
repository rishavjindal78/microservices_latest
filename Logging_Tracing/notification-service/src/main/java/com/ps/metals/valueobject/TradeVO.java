package com.ps.metals.valueobject;

public class TradeVO {
	
	/*
	 * private int id; private String side; private int quntity; private double
	 * price; private Date tradeDate; private String status;
	 */
	private Trade trade;
	
	private String commodityName;
	private String counterparty;
	private String location;
	
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCounterparty() {
		return counterparty;
	}
	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
