package com.elandjo.snowalert.infrastructure.converter.testdoubles;

import com.elandjo.snowalert.infrastructure.converter.JSONConverters;

public class JSONConvertersStub extends JSONConverters {
	private String stubbedJSONResponse;
	private Object target;

	public String convert(Object target) {
		this.target = target;
		return stubbedJSONResponse;
	}

	public void setStubbedJSONResponse(String stubbedJSONResponse) {
		this.stubbedJSONResponse = stubbedJSONResponse;
	}

	public Object convertInvokedWith() {
		return target;
	}
}