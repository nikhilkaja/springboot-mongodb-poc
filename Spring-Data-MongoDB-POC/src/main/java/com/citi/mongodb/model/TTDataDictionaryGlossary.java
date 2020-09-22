package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "glossary")
public class TTDataDictionaryGlossary {

	@Id
	private String glossaryId;
	private String release;
	private String implementedOn;
	private String variable;
	private String name;
	private String contextData;
	private String status;
	private String description;
	private String loadRules;
	private String formatOrSampleValues;
	public String getGlossaryId() {
		return glossaryId;
	}
	public void setGlossaryId(String glossaryId) {
		this.glossaryId = glossaryId;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getImplementedOn() {
		return implementedOn;
	}
	public void setImplementedOn(String implementedOn) {
		this.implementedOn = implementedOn;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContextData() {
		return contextData;
	}
	public void setContextData(String contextData) {
		this.contextData = contextData;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLoadRules() {
		return loadRules;
	}
	public void setLoadRules(String loadRules) {
		this.loadRules = loadRules;
	}
	public String getFormatOrSampleValues() {
		return formatOrSampleValues;
	}
	public void setFormatOrSampleValues(String formatOrSampleValues) {
		this.formatOrSampleValues = formatOrSampleValues;
	}
	
	
}
