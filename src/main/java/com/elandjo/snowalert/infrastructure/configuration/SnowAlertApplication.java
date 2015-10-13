package com.elandjo.snowalert.infrastructure.configuration;

import com.elandjo.snowalert.infrastructure.resource.condition.ConditionsResource;
import com.elandjo.snowalert.infrastructure.resource.destination.DestinationsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SnowAlertApplication extends Application<SnowAlertConfiguration> {
	public static void main(String[] args) throws Exception {
		new SnowAlertApplication().run(args);
	}

	@Override
	public void run(SnowAlertConfiguration configuration, Environment environment) throws Exception {
		final DestinationsResource destinationsResource = new DestinationsResource();
		final ConditionsResource conditionsResource = new ConditionsResource();

		environment.jersey().register(destinationsResource);
		environment.jersey().register(conditionsResource);
	}

	@Override
	public String getName() {
		return "snow-alert";
	}
}