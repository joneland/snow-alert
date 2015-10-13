package com.elandjo.snowalert.infrastructure.resource.destination;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

class Countries {
	private final List<Country> countries = new ArrayList<Country>();

	void add(Country country) {
		countries.add(country);
	}

	@JsonProperty
	List<Country> getCountries() {
		return countries;
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