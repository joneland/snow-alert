package com.elandjo.snowalert.infrastructure.country.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Countries {
	private URI baseUri;
	private List<Country> countries = new ArrayList<Country>();

	public Countries(URI baseUri) {
		this.baseUri = baseUri;
	}

	public void withCountry(String id, String name) {
		countries.add(new Country(id, name));
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

	class Country {
		private String name;
		private String link;

		public Country(String id, String name) {
			this.name = name;
			this.link = baseUri + "country/" + id;
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
}