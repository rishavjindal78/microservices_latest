package com.ps.metals.controller;

import static com.ps.metals.model.ResponseWrapper.failure;
import static com.ps.metals.model.ResponseWrapper.success;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.metals.model.RefData;
import com.ps.metals.model.RefDataEntity;
import com.ps.metals.model.ResponseWrapper;
import com.ps.metals.service.RefDataService;

@RestController
@RequestMapping("/refdata")
public class RefDataController {

	private static Logger log = LoggerFactory.getLogger(RefDataController.class);
	
    @Autowired
    @Qualifier("locationDataService")
    private RefDataService locationDataService;
    @Autowired
    @Qualifier("counterPartyDataService")
    private RefDataService counterPartyDataService;
    @Autowired
    @Qualifier("commodityDataService")
    private RefDataService commodityDataService;


    @GetMapping("/{entityTypeName}")
    public ResponseEntity<ResponseWrapper> getRefData(@PathVariable String entityTypeName) {
    	log.info("Entered into the contoller method getRefData with entityTypeName::");
        Optional<RefDataEntity> entityOptional = RefDataEntity.byName(entityTypeName);
        if (!entityOptional.isPresent()) {
            return new ResponseEntity<ResponseWrapper>(failure("Reference data type - " + entityTypeName + " is not supported"), HttpStatus.BAD_REQUEST);
        }
        RefDataEntity entityType = entityOptional.get();
        List<Ref> refData;
        switch (entityType) {
            case LOCATION:
                refData = locationDataService.getRefData();
                break;
            case COMMODITY:
                refData = commodityDataService.getRefData();
                break;
            case COUNTER_PARTY:
                refData = counterPartyDataService.getRefData();
                break;
            default:
                return new ResponseEntity<ResponseWrapper>(failure("Reference data type - " + entityType + " is not supported"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ResponseWrapper>(success(refData), HttpStatus.OK);
    }

    @GetMapping("/{entityTypeName}/{code}")
    public ResponseEntity<ResponseWrapper> getRefData(@PathVariable String entityTypeName, @PathVariable String code) {
    	log.info("Entered into the contoller method getRefData with entityTypeName & code::");
        Optional<RefDataEntity> entityOptional = RefDataEntity.byName(entityTypeName);
        if (!entityOptional.isPresent()) {
            return new ResponseEntity<ResponseWrapper>(failure("Reference data type - " + entityTypeName + " is not supported"), HttpStatus.BAD_REQUEST);
        }
        RefDataEntity entityType = entityOptional.get();
        Optional<RefData> refData;
        switch (entityType) {
            case LOCATION:
                refData = locationDataService.getByCode(code);
                break;
            case COMMODITY:
                refData = commodityDataService.getByCode(code);
                break;
            case COUNTER_PARTY:
                refData = counterPartyDataService.getByCode(code);
                break;
            default:
                return new ResponseEntity<ResponseWrapper>(failure("Reference data type - " + entityType + " is not supported"), HttpStatus.BAD_REQUEST);
        }

        if (!refData.isPresent()) {
            return new ResponseEntity<ResponseWrapper>(failure(entityType.getName() + " not found for code " + code), HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<ResponseWrapper>(success(refData), HttpStatus.OK);
    }
}
