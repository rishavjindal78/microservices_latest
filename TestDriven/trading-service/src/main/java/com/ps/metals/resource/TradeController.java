package com.ps.metals.resource;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ps.metals.bean.type.TradeRefData;
import com.ps.metals.entity.Trade;
import com.ps.metals.helper.TradeServiceHelper;
import com.ps.metals.openfeign.RefDataServiceFeignClient;
import com.ps.metals.repository.TradeRepository;
import com.ps.metals.valueobject.RefDataVO;
import com.ps.metals.valueobject.ResponseWrapperVO;
import com.ps.metals.valueobject.TradeVO;

@RestController
@RequestMapping("/trades")
public class TradeController {
	
	private static final Logger log = LoggerFactory.getLogger(TradeController.class);
	
	private static final String TOPIC = "trade_producer";
	
	@Autowired
	private RefDataServiceFeignClient feignClient;
	
	@Autowired
	private TradeServiceHelper helper;
	
	@Autowired
	private TradeRepository repository;
	
	@Autowired
	private KafkaTemplate<String, TradeVO> kafkaTemplate;
	
	
	@RequestMapping("/all")
	public List<Trade> trades() {
		log.info("entered into all trades::::");
		return repository.findAll();
	}
	
	
	@RequestMapping(value = "/{tradeId}", method = RequestMethod.GET)
	public Trade getTrade(@PathVariable String tradeId) {
		log.info("Getting user with ID: {}.", tradeId);
		
		return repository.findById(tradeId).get();
	}
	
	@GetMapping("/aggregate/{tradeId}")
	public ResponseEntity<TradeVO> aggregate(@PathVariable String tradeId) {
		log.info("entered into aggregate::::");
		log.debug("entered into aggregate::::");

		log.warn("entered into aggregate::::");

		log.trace("entered into aggregate::::");

		//log.error("entered into aggregate::::");

		
		
		TradeVO tradeVO = new TradeVO();
		
		tradeVO.setTrade(repository.findById(tradeId).get());

		ResponseEntity<ResponseWrapperVO> response = feignClient.getRefData("location","DC");
		
		RefDataVO refData = new RefDataVO("location","DC");
		
		tradeVO = helper.prepareTrade(tradeVO, refData, TradeRefData.LOCATION);
		
		//refData = (RefDataVO) ((ResponseEntity<ResponseWrapperVO>) feignClient.getRefData("counterParty","ICE")).getBody().getData();
		refData = new RefDataVO("counterParty","ICE");
		tradeVO = helper.prepareTrade(tradeVO, refData, TradeRefData.COUNTER_PARTY);
		
		//refData = (RefDataVO) ((ResponseEntity<ResponseWrapperVO>) feignClient.getRefData("commodity","CRUDEOIL")).getBody().getData();
		
		refData = new RefDataVO("commodity","CRUDEOIL");

		
		tradeVO = helper.prepareTrade(tradeVO, refData, TradeRefData.COMMODITY);
		
		kafkaTemplate.send(TOPIC, tradeVO);

		return new ResponseEntity<>(tradeVO,HttpStatus.OK);
	}

}
