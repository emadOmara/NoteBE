package com.emad.integration;

import java.io.IOException;

import com.emad.model.Note;
import com.emad.model.Tag;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TagSerializer extends JsonSerializer<Tag> {
	@Override
	public void serialize(Tag value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeNumberField("id", value.getId());
		jgen.writeEndObject();
	}
}