package com.elandjo.snowalert.infrastructure.resource.destination;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;

class Regions {
	private List<Region> regions = new ArrayList<Region>();

	void add(Region region) {
		regions.add(region);
	}

	@JsonProperty
	List<Region> getRegions() {
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
}