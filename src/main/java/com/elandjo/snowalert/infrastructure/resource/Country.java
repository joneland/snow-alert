package com.elandjo.snowalert.infrastructure.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.net.URI;

public class Country {
	private String name;
	private String link;

	public Country(String name, URI requestUri) {
		this.name = name;
		this.link = requestUri + "/" + name;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public String getLink() {
		return link;
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