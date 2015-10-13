package com.elandjo.snowalert.infrastructure.resource.destination;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.net.URI;

class Region {
	private String name;
	private String link;

	Region(String name, URI requestUri) {
		this.name = name;
		this.link = requestUri + "/" + name;
	}

	@JsonProperty
	String getName() {
		return name;
	}

	@JsonProperty
	String getLink() {
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
