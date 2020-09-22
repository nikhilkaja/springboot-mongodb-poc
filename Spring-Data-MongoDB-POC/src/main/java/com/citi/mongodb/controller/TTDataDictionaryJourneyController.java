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

import com.citi.mongodb.dal.TTDataDictionaryJourneyRepository;
import com.citi.mongodb.exception.RecordNotFoundException;
import com.citi.mongodb.model.TTDataDictionaryJourney;

@RestController
@RequestMapping("/v1")
public class TTDataDictionaryJourneyController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
   
	@Autowired
    private TTDataDictionaryJourneyRepository ttDataDictionaryJourneyRepository;


    @GetMapping("/getJournies")
    public List <TTDataDictionaryJourney> getDataDictionaries() {
    	LOG.info("Fetching ttDataDictionaryJourney data");
        return ttDataDictionaryJourneyRepository.findAll();
    }

    @GetMapping("/getJourney/{id}")
    public ResponseEntity <TTDataDictionaryJourney> getDataDictionaryById(@PathVariable(value = "id") String id)
    throws RecordNotFoundException {
    	LOG.info("Getting ttDataDictionaryJourney data for id :: "+id);
    	TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(id);
     	if(null == ttDataDictionaryJourney) {
     		throw new RecordNotFoundException("Record not found for this id :: "+id);
     	}
        return ResponseEntity.ok().body(ttDataDictionaryJourney);
    }

    @PostMapping("/saveJourney")
    public TTDataDictionaryJourney createDataDictionary(@Valid @RequestBody TTDataDictionaryJourney ttDataDictionaryDomain) {
    	LOG.info("Saving ttDataDictionaryJourney data.");
        return ttDataDictionaryJourneyRepository.save(ttDataDictionaryDomain);
    }

    @PutMapping("/updateJourney/{id}")
    public ResponseEntity < TTDataDictionaryJourney > updateDataDictionary(@PathVariable(value = "id") String id,
        @Valid @RequestBody TTDataDictionaryJourney updateTTDataDictionary) throws RecordNotFoundException {
       
    	TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(id);
    	if(null == ttDataDictionaryJourney) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	
    	//update Data
    	LOG.info("updating ttDataDictionaryJourney data for id :: "+id);
    	ttDataDictionaryJourney.setJourneyId(updateTTDataDictionary.getJourneyId());
    	ttDataDictionaryJourney.setApplyForAccount(updateTTDataDictionary.getApplyForAccount());
    	ttDataDictionaryJourney.setOnboardForAccount(updateTTDataDictionary.getOnboardForAccount());
    	ttDataDictionaryJourney.setShopForAccount(updateTTDataDictionary.getShopForAccount());
    	ttDataDictionaryJourney.setAddAdditionalCreditAndLoans(updateTTDataDictionary.getAddAdditionalCreditAndLoans());
    	ttDataDictionaryJourney.setBorrowNewFunds(updateTTDataDictionary.getBorrowNewFunds());
    	ttDataDictionaryJourney.setPricingOrAPROrFee(updateTTDataDictionary.getPricingOrAPROrFee());
    	ttDataDictionaryJourney.setRestructureExistingCredit(updateTTDataDictionary.getRestructureExistingCredit());
    	ttDataDictionaryJourney.setTransferLoans(updateTTDataDictionary.getTransferLoans());
    	ttDataDictionaryJourney.setMessaging(updateTTDataDictionary.getMessaging());
    	ttDataDictionaryJourney.setMobileContainer(updateTTDataDictionary.getMobileContainer());
    	ttDataDictionaryJourney.setNonDigital(updateTTDataDictionary.getNonDigital());
    	ttDataDictionaryJourney.setDigitalContainer(updateTTDataDictionary.getDigitalContainer());
    	ttDataDictionaryJourney.setVoice(updateTTDataDictionary.getVoice());
    	ttDataDictionaryJourney.setAddAProduceOrService(updateTTDataDictionary.getAddAProduceOrService());
    	ttDataDictionaryJourney.setCrossSellAndUpgrades(updateTTDataDictionary.getCrossSellAndUpgrades());
    	ttDataDictionaryJourney.setManageMyBenifits(updateTTDataDictionary.getManageMyBenifits());
    	ttDataDictionaryJourney.setManageMyRewards(updateTTDataDictionary.getManageMyRewards());
    	ttDataDictionaryJourney.setOnboardMyAccount(updateTTDataDictionary.getOnboardMyAccount());
    	ttDataDictionaryJourney.setLoginAutnetication(updateTTDataDictionary.getLoginAutnetication());
    	ttDataDictionaryJourney.setManageProfile(updateTTDataDictionary.getManageProfile());
    	ttDataDictionaryJourney.setProtectIdentity(updateTTDataDictionary.getProtectIdentity());
    	ttDataDictionaryJourney.setRegisterForDigitalAccess(updateTTDataDictionary.getRegisterForDigitalAccess());
    	ttDataDictionaryJourney.setSecureMyInformation(updateTTDataDictionary.getSecureMyInformation());
    	ttDataDictionaryJourney.setBillPay(updateTTDataDictionary.getBillPay());
    	ttDataDictionaryJourney.setMakeADigitalPurchase(updateTTDataDictionary.getMakeADigitalPurchase());
    	
		
        final TTDataDictionaryJourney updateDataDictionary = ttDataDictionaryJourneyRepository.save(ttDataDictionaryJourney);
        return ResponseEntity.ok(updateDataDictionary);
    }


	@DeleteMapping("/deleteJourney/{id}")
    public Map < String, Boolean > deleteDataDictionary(@PathVariable(value = "id") String id) throws RecordNotFoundException {
		TTDataDictionaryJourney ttDataDictionaryJourney = ttDataDictionaryJourneyRepository.findOne(id);
    	
    	if(null == ttDataDictionaryJourney) {
    		throw new RecordNotFoundException("Record not found for this id :: "+id);
    	}
    	LOG.info("Deleting ttDataDictionaryJourney data for id :: "+id);
    	ttDataDictionaryJourneyRepository.delete(ttDataDictionaryJourney);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}