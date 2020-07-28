package com.ps.metals.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ps.metals.bean.type.TradeRefData;
import com.ps.metals.valueobject.RefDataVO;
import com.ps.metals.valueobject.TradeVO;

@Component
public class TradeServiceHelper {
	
	private static Logger log = LoggerFactory.getLogger(TradeServiceHelper.class);

	public TradeVO prepareTrade(TradeVO tradeVO, RefDataVO refDataVO, TradeRefData type) {
		switch (type) {
			case LOCATION:
				log.info("Entered into LOCATION::");
				tradeVO.setLocation(refDataVO.getName());
				break;
			case COMMODITY:
				log.info("Entered into COMMODITY::");
				tradeVO.setCommodityName(refDataVO.getName());
				break;
			case COUNTER_PARTY:
				log.info("Entered into COUNTER_PARTY::");
				tradeVO.setCounterparty(refDataVO.getName());
				break;
			default:
				return tradeVO;
		}
		return tradeVO;
	}
}
