package com.emad.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.emad.model.Note;
import com.emad.model.Tag;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class NoteSerializer extends JsonSerializer<Note> {
	@Override
	public void serialize(Note value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeStringField("title",value.getTitle());
		jgen.writeStringField("createdDate",value.getCreatedDate().toString());
		jgen.writeStringField("description", value.getDescription());
//		List<Long>
		jgen.writeArrayFieldStart("tag");
		 List<Long>ids=new ArrayList<Long>();
		 for(Tag t : value.getTags()){
			 ids.add(t.getId());
			}
		 
	        jgen.writeStringField("tag", ids.toString());
	        
		jgen.writeEndObject();
	}
 
}