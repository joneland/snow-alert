package com.elandjo.snowalert.infrastructure.resort.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public class Resort {
	private String name;
	private URI baseUri;

	public Resort(String name, URI baseUri) {
		this.name = name;
		this.baseUri = baseUri;
	}

	@JsonProperty
	public String getName() {
		return name;
	}
}