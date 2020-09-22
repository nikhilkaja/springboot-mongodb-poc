package com.citi.mongodb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.mongodb.dal.TTDataDictionaryPropRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryProp;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryPropController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryPropRepository ttDataDictionaryPropRepository;


    @GetMapping("/getProps")
    public List <TTDataDictionaryProp> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryProp data");
        return ttDataDictionaryPropRepository.findAll();
    }

    @GetMapping("/getProp/{id}")
    public ResponseEntity <TTDataDictionaryProp> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryProp data for id :: "+ id);
    	 TTDataDictionaryProp ttDataDictionaryProp = ttDataDictionaryPropRepository.findOne(id);
     	if(null == ttDataDictionaryProp) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryProp);
    }

    @PostMapping("/saveProp")
    public TTDataDictionaryProp createDataDictionary(@Valid @RequestBody TTDataDictionaryProp ttDataDictionaryProp) {
    	LOG.info("Saving ttDataDictionaryProp data.");
        return ttDataDictionaryPropRepository.save(ttDataDictionaryProp);
    }

    @PutMapping("/updateProp/{id}")
    public ResponseEntity < TTDataDictionaryProp > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionaryProp updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryProp ttDataDictionaryProp = ttDataDictionaryPropRepository.findOne(id);
    	if(null == ttDataDictionaryProp) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryProp data for id :: "+id);
    	ttDataDictionaryProp.setPropDataType(updateTTDataDictionary.getPropDataType());
		ttDataDictionaryProp.setPropRelease(updateTTDataDictionary.getPropRelease());
		ttDataDictionaryProp.setPropImplementedOn(updateTTDataDictionary.getPropImplementedOn());
		ttDataDictionaryProp.setPropProdStartDate(updateTTDataDictionary.getPropProdStartDate());
		ttDataDictionaryProp.setPropVariable(updateTTDataDictionary.getPropVariable());
		ttDataDictionaryProp.setPropName(updateTTDataDictionary.getPropName());
		ttDataDictionaryProp.setPropContextData(updateTTDataDictionary.getPropContextData());
		ttDataDictionaryProp.setPropStatus(updateTTDataDictionary.getPropStatus());
		ttDataDictionaryProp.setPropDescription(updateTTDataDictionary.getPropDescription());
		ttDataDictionaryProp.setPropAllocation(updateTTDataDictionary.getPropAllocation());
		ttDataDictionaryProp.setPropExpiration(updateTTDataDictionary.getPropExpiration());
		ttDataDictionaryProp.setPropMerchHandizing(updateTTDataDictionary.getPropMerchHandizing());
		ttDataDictionaryProp.setPropTTUsage(updateTTDataDictionary.getPropTTUsage());
		ttDataDictionaryProp.setPropMobileUsage(updateTTDataDictionary.getPropMobileUsage());
		ttDataDictionaryProp.setPropMobileVariable(updateTTDataDictionary.getPropMobileVariable());
		ttDataDictionaryProp.setPropGlobalVariable(updateTTDataDictionary.getPropGlobalVariable());
		ttDataDictionaryProp.setPropCitiNaProdVariable(updateTTDataDictionary.getPropCitiNaProdVariable());
		ttDataDictionaryProp.setPropMenuGrouping(updateTTDataDictionary.getPropMenuGrouping());
		ttDataDictionaryProp.setPropReplication(updateTTDataDictionary.getPropReplication());
    	
    	
        final TTDataDictionaryProp updateDataDictionary = ttDataDictionaryPropRepository.save(ttDataDictionaryProp);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteProp/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
		TTDataDictionaryProp ttDataDictionaryProp = ttDataDictionaryPropRepository.findOne(id);
    	
    	if(null == ttDataDictionaryProp) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionaryProp data for id :: "+id);
    	ttDataDictionaryPropRepository.delete(ttDataDictionaryProp);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}