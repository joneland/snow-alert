package com.elandjo.snowalert.infrastructure.converter.testdoubles;

import com.elandjo.snowalert.infrastructure.converter.JSONConverters;

public class JSONConvertersStub extends JSONConverters {
	private String stubbedJSONResponse;

	public String convert(Object target) {
		return stubbedJSONResponse;
	}

	public void setStubbedJSONResponse(String stubbedJSONResponse) {
		this.stubbedJSONResponse = stubbedJSONResponse;
	}
}