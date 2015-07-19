package com.elandjo.snowalert.infrastructure.configuration;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class SnowAlertConfiguration extends Configuration {
	@NotEmpty
	private String defaultName = "Stranger";

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
}