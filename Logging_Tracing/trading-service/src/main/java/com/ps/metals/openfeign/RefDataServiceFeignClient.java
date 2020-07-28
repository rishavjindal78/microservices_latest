package com.ps.metals.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ps.metals.valueobject.ResponseWrapperVO;

@Component
@FeignClient("ref-data-service")
public interface RefDataServiceFeignClient {
	
	@GetMapping("refdata/{entityTypeName}")
    public ResponseEntity<ResponseWrapperVO> getRefData(@PathVariable String entityTypeName);
	
	
	@GetMapping("refdata/{entityTypeName}/{code}")
    public ResponseEntity<ResponseWrapperVO> getRefData(@PathVariable String entityTypeName, @PathVariable String code);
	

}
