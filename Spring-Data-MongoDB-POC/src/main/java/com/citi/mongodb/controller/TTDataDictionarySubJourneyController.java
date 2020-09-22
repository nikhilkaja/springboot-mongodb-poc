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

import com.citi.mongodb.dal.TTDataDictionarySubJourneyRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionarySubJourney;

@RestController
@RequestMapping("/v1")
public class TTDataDictionarySubJourneyController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionarySubJourneyRepository ttDataDictionarySubJourneyRepository;


    @GetMapping("/getSubJourneys")
    public List <TTDataDictionarySubJourney> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionarySubJourney data");
        return ttDataDictionarySubJourneyRepository.findAll();
    }

    @GetMapping("/getSubJourney/{id}")
    public ResponseEntity <TTDataDictionarySubJourney> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionarySubJourney data for id :: "+id);
    	TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(id);
     	if(null == ttDataDictionarySubJourney) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionarySubJourney);
    }

    @PostMapping("/saveSubJourney")
    public TTDataDictionarySubJourney createDataDictionary(@Valid @RequestBody TTDataDictionarySubJourney ttDataDictionarySubJourney) {
    	LOG.info("Saving ttDataDictionarySubJourney data.");
        return ttDataDictionarySubJourneyRepository.save(ttDataDictionarySubJourney);
    }

    @PutMapping("/updateSubJourney/{id}")
    public ResponseEntity < TTDataDictionarySubJourney > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionarySubJourney updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(id);
    	if(null == ttDataDictionarySubJourney) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionarySubJourney data for id :: "+id);
		
    	ttDataDictionarySubJourney.setSubJourneyId(updateTTDataDictionary.getSubJourneyId());
    	ttDataDictionarySubJourney.setBankApplication(updateTTDataDictionary.getBankApplication());
    	ttDataDictionarySubJourney.setCardApplication(updateTTDataDictionary.getCardApplication());
    	ttDataDictionarySubJourney.setActivation(updateTTDataDictionary.getActivation());
    	ttDataDictionarySubJourney.setFindAndLearn(updateTTDataDictionary.getFindAndLearn());
    	ttDataDictionarySubJourney.setCli(updateTTDataDictionary.getCli());
    	ttDataDictionarySubJourney.setCashAdavance(updateTTDataDictionary.getCashAdavance());
    	ttDataDictionarySubJourney.setLineOfCredit(updateTTDataDictionary.getLineOfCredit());
    	ttDataDictionarySubJourney.setMonitorMyLoan(updateTTDataDictionary.getMonitorMyLoan());
    	ttDataDictionarySubJourney.setOpenLoanAccount(updateTTDataDictionary.getOpenLoanAccount());
    	ttDataDictionarySubJourney.setPil(updateTTDataDictionary.getPil());
    	ttDataDictionarySubJourney.setApr(updateTTDataDictionary.getApr());
    	ttDataDictionarySubJourney.setCreditWarning(updateTTDataDictionary.getCreditWarning());
    	ttDataDictionarySubJourney.setFee(updateTTDataDictionary.getFee());
    	ttDataDictionarySubJourney.setPricing(updateTTDataDictionary.getPricing());
    	ttDataDictionarySubJourney.setBalanceTransfers(updateTTDataDictionary.getBalanceTransfers());
    	ttDataDictionarySubJourney.setChatrBots(updateTTDataDictionary.getChatrBots());
    	ttDataDictionarySubJourney.setOlsMessage(updateTTDataDictionary.getOlsMessage());
    	ttDataDictionarySubJourney.setSecureMessage(updateTTDataDictionary.getSecureMessage());
    	ttDataDictionarySubJourney.setAtmBranchLocations(updateTTDataDictionary.getAtmBranchLocations());
    	ttDataDictionarySubJourney.setContactUs(updateTTDataDictionary.getContactUs());
    	ttDataDictionarySubJourney.setFaq(updateTTDataDictionary.getFaq());
    	ttDataDictionarySubJourney.setFeedback(updateTTDataDictionary.getFeedback());
    	ttDataDictionarySubJourney.setHelp(updateTTDataDictionary.getHelp());
    	ttDataDictionarySubJourney.setSearch(updateTTDataDictionary.getSearch());
    	
    	
        final TTDataDictionarySubJourney updateDataDictionary = ttDataDictionarySubJourneyRepository.save(ttDataDictionarySubJourney);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteSubJourney/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
		TTDataDictionarySubJourney ttDataDictionarySubJourney = ttDataDictionarySubJourneyRepository.findOne(id);
    	
    	if(null == ttDataDictionarySubJourney) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionarySubJourney data for id :: "+id);
    	ttDataDictionarySubJourneyRepository.delete(ttDataDictionarySubJourney);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}