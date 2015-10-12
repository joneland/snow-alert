package com.elandjo.snowalert.infrastructure.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Resorts {
	private List<Resort> resorts = new ArrayList<Resort>();

	public void add(Resort resort) {
		resorts.add(resort);
	}

	@JsonProperty
	public List<Resort> getResorts() {
		return resorts;
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