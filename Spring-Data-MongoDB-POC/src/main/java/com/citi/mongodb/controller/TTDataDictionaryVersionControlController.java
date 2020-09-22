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

import com.citi.mongodb.dal.TTDataDictionaryVersionControlRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryVersionControl;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryVersionControlController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryVersionControlRepository ttDataDictionaryVersionControlRepository;


    @GetMapping("/getVersionControls")
    public List <TTDataDictionaryVersionControl> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryVersionControl data");
        return ttDataDictionaryVersionControlRepository.findAll();
    }

    @GetMapping("/getVersionControl/{id}")
    public ResponseEntity <TTDataDictionaryVersionControl> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryVersionControl data for id :: "+id);
    	TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(id);
     	if(null == ttDataDictionaryVersionControl) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryVersionControl);
    }

    @PostMapping("/saveVersionControl")
    public TTDataDictionaryVersionControl createDataDictionary(@Valid @RequestBody TTDataDictionaryVersionControl ttDataDictionaryVersionControl) {
    	LOG.info("Saving ttDataDictionaryVersionControl data.");
        return ttDataDictionaryVersionControlRepository.save(ttDataDictionaryVersionControl);
    }

    @PutMapping("/updateVersionControl/{id}")
    public ResponseEntity < TTDataDictionaryVersionControl > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionaryVersionControl updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(id);
    	if(null == ttDataDictionaryVersionControl) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryVersionControl data for id :: "+id);
    	ttDataDictionaryVersionControl.setChange(updateTTDataDictionary.getChange());
    	ttDataDictionaryVersionControl.setChangeAuthor(updateTTDataDictionary.getChangeAuthor());
    	ttDataDictionaryVersionControl.setChangeDate(updateTTDataDictionary.getChangeDate());
    	ttDataDictionaryVersionControl.setChangeDescription(updateTTDataDictionary.getChangeDescription());
    	ttDataDictionaryVersionControl.setChangeNumber(updateTTDataDictionary.getChangeNumber());
    	
        final TTDataDictionaryVersionControl updateDataDictionary = ttDataDictionaryVersionControlRepository.save(ttDataDictionaryVersionControl);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteVersionControl/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
		TTDataDictionaryVersionControl ttDataDictionaryVersionControl = ttDataDictionaryVersionControlRepository.findOne(id);
    	
    	if(null == ttDataDictionaryVersionControl) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionaryVersionControl data for id :: "+id);
    	ttDataDictionaryVersionControlRepository.delete(ttDataDictionaryVersionControl);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}