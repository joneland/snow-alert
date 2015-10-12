package com.elandjo.snowalert.infrastructure.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

public class Countries {
	private final List<Country> countries = new ArrayList<Country>();

	public void add(Country country) {
		countries.add(country);
	}

	@JsonProperty
	public List<Country> getCountries() {
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