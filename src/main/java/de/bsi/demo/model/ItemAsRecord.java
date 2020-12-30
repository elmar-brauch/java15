package de.bsi.demo.model;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Records have been introduced with Java version 14.
 * In order to get it working with Jackson's JSON parser, the JsonProperty annotation is required. 
 * 
 * @author Elmar Brauch
 */
public record ItemAsRecord(
		@Positive @JsonProperty("id") int id, 
		@NotBlank @JsonProperty("name") String name, 
		@Size(max = 5) @JsonProperty("location") String location){}