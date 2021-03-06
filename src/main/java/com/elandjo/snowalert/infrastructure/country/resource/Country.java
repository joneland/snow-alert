package com.elandjo.snowalert.infrastructure.country.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class Country {
	private String name;
	private URI baseUri;
	private List<Region> regions = new ArrayList<Region>();

	public Country(String name, URI baseUri) {
		this.name = name;
		this.baseUri = baseUri;
	}

	public void withRegion(String id, String name) {
		regions.add(new Region(id, name));
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public List<Region> getRegions() {
		return regions;
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	class Region {
		private final String name;
		private final String link;

		public Region(String id, String name) {
			this.name = name;
			this.link = baseUri + "region/" + id;
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