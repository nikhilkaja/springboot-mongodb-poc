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

import com.citi.mongodb.dal.TTDataDictionaryDomainRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryDomain;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryDomainController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryDomainRepository ttDataDictionaryDomainRepository;


    @GetMapping("/getDomains")
    public List <TTDataDictionaryDomain> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryDomain data");
        return ttDataDictionaryDomainRepository.findAll();
    }

    @GetMapping("/getDomain/{id}")
    public ResponseEntity <TTDataDictionaryDomain> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryDomain data for id :: "+id);
    	TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(id);
     	if(null == ttDataDictionaryDomain) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryDomain);
    }

    @PostMapping("/saveDomain")
    public TTDataDictionaryDomain createDataDictionary(@Valid @RequestBody TTDataDictionaryDomain ttDataDictionaryDomain) {
    	LOG.info("Saving ttDataDictionaryDomain data.");
        return ttDataDictionaryDomainRepository.save(ttDataDictionaryDomain);
    }

    @PutMapping("/updateDomain/{id}")
    public ResponseEntity < TTDataDictionaryDomain > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionaryDomain updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(id);
    	if(null == ttDataDictionaryDomain) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryDomain data for id :: "+id);
    	
    	ttDataDictionaryDomain.setAcquire(updateTTDataDictionary.getAcquire());
    	ttDataDictionaryDomain.setBorrow(updateTTDataDictionary.getBorrow());
    	ttDataDictionaryDomain.setDomainId(updateTTDataDictionary.getDomainId());
    	ttDataDictionaryDomain.setEnable(updateTTDataDictionary.getEnable());
    	ttDataDictionaryDomain.setGrow(updateTTDataDictionary.getGrow());
    	ttDataDictionaryDomain.setIdentify(updateTTDataDictionary.getIdentify());
    	ttDataDictionaryDomain.setPay(updateTTDataDictionary.getPay());
    	ttDataDictionaryDomain.setSaveAndInvest(updateTTDataDictionary.getSaveAndInvest());
    	ttDataDictionaryDomain.setServicing(updateTTDataDictionary.getServicing());
    	
        final TTDataDictionaryDomain updateDataDictionary = ttDataDictionaryDomainRepository.save(ttDataDictionaryDomain);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteDomain/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
		TTDataDictionaryDomain ttDataDictionaryDomain = ttDataDictionaryDomainRepository.findOne(id);
    	
    	if(null == ttDataDictionaryDomain) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionaryDomain data for id :: "+id);
    	ttDataDictionaryDomainRepository.delete(ttDataDictionaryDomain);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}