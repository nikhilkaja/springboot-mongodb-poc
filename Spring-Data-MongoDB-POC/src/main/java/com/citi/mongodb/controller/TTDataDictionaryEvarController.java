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

import com.citi.mongodb.dal.TTDataDictionaryEvarRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryEvar;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryEvarController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryEvarRepository ttDataDictionaryRepository;


    @GetMapping("/ttDataDictionaries")
    public List <TTDataDictionaryEvar> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryEvar data");
        return ttDataDictionaryRepository.findAll();
    }

    @GetMapping("/ttDataDictionary/{id}")
    public ResponseEntity <TTDataDictionaryEvar> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryEvar data for id :: "+id);
    	 TTDataDictionaryEvar ttDataDictionaryEvar = ttDataDictionaryRepository.findOne(id);
     	if(null == ttDataDictionaryEvar) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryEvar);
    }

    @PostMapping("/ttDataDictionary")
    public TTDataDictionaryEvar createDataDictionary(@Valid @RequestBody TTDataDictionaryEvar ttDataDictionaryEvar) {
    	LOG.info("Saving ttDataDictionaryEvar data.");
        return ttDataDictionaryRepository.save(ttDataDictionaryEvar);
    }

    @PutMapping("/ttDataDictionary/{id}")
    public ResponseEntity < TTDataDictionaryEvar > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionaryEvar updateTTDataDictionary) throws RecordNotFoundException {
       
       TTDataDictionaryEvar ttDataDictionaryEvar = ttDataDictionaryRepository.findOne(id);
    	if(null == ttDataDictionaryEvar) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryEvar data for id :: "+id);
		ttDataDictionaryEvar.setEvarDataType(updateTTDataDictionary.getEvarDataType());
		ttDataDictionaryEvar.setEvarRelease(updateTTDataDictionary.getEvarRelease());
		ttDataDictionaryEvar.setEvarImplementedOn(updateTTDataDictionary.getEvarImplementedOn());
		ttDataDictionaryEvar.setEvarProdStartDate(updateTTDataDictionary.getEvarProdStartDate());
		ttDataDictionaryEvar.setEvarVariable(updateTTDataDictionary.getEvarVariable());
		ttDataDictionaryEvar.setEvarName(updateTTDataDictionary.getEvarName());
		ttDataDictionaryEvar.setEvarContextData(updateTTDataDictionary.getEvarContextData());
		ttDataDictionaryEvar.setEvarStatus(updateTTDataDictionary.getEvarStatus());
		ttDataDictionaryEvar.setEvarDescription(updateTTDataDictionary.getEvarDescription());
		ttDataDictionaryEvar.setEvarEvarAllocation(updateTTDataDictionary.getEvarEvarAllocation());
		ttDataDictionaryEvar.setEvarEvarExpiration(updateTTDataDictionary.getEvarEvarExpiration());
		ttDataDictionaryEvar.setEvarMerchHandizing(updateTTDataDictionary.getEvarMerchHandizing());
		ttDataDictionaryEvar.setEvarTTUsage(updateTTDataDictionary.getEvarTTUsage());
		ttDataDictionaryEvar.setEvarMobileUsage(updateTTDataDictionary.getEvarMobileUsage());
		ttDataDictionaryEvar.setEvarMobileVariable(updateTTDataDictionary.getEvarMobileVariable());
		ttDataDictionaryEvar.setEvarGlobalVariable(updateTTDataDictionary.getEvarGlobalVariable());
		ttDataDictionaryEvar.setEvarCitiNaProdVariable(updateTTDataDictionary.getEvarCitiNaProdVariable());
		ttDataDictionaryEvar.setEvarMenuGrouping(updateTTDataDictionary.getEvarMenuGrouping());
		ttDataDictionaryEvar.setEvarReplication(updateTTDataDictionary.getEvarReplication());
    	
    	
        final TTDataDictionaryEvar updateDataDictionary = ttDataDictionaryRepository.save(ttDataDictionaryEvar);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/ttDataDictionary/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
    	TTDataDictionaryEvar ttDataDictionaryEvar = ttDataDictionaryRepository.findOne(id);
    	
    	if(null == ttDataDictionaryEvar) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionaryEvar data for id :: "+id);
    	ttDataDictionaryRepository.delete(ttDataDictionaryEvar);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}