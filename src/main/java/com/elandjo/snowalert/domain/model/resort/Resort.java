package com.elandjo.snowalert.domain.model.resort;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Resort {
	private final String resortName;

	public static final Resort UNKNOWN = new Resort("Unknown Resort");

	public Resort(final String resortName) {
		this.resortName = resortName;
	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}