package com.elandjo.snowalert.infrastructure.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.net.URI;

public class Resort {
	private String name;
	private String link;

	public Resort(String name, Integer id, URI uri) {
		this.name = name;
		this.link = uri + "conditions/" + id;
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