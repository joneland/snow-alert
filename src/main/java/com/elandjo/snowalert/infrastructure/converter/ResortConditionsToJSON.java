package com.elandjo.snowalert.infrastructure.converter;

import com.elandjo.snowalert.domain.model.resort.ResortConditions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

class ResortConditionsToJSON {
	static String convert(ResortConditions resortConditions) {
		ObjectMapper objectMapper = new ObjectMapper().setVisibility(FIELD, ANY);
		try {
			return objectMapper.writeValueAsString(resortConditions);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Could not convert resort conditions to JSON", e);
		}
	}
}