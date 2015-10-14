package com.elandjo.snowalert.infrastructure.resort.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}