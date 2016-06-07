package com.emad.integration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {
	  @Override
	  public Date deserialize(JsonParser jsonparser,
	                          DeserializationContext deserializationcontext) throws IOException {
	    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    String date = jsonparser.getText();
	    try {
	      return format.parse(date);
	    }  catch (java.text.ParseException e) {
	    	e.printStackTrace();
			 
		}
		return null;
		 
	  }
	}