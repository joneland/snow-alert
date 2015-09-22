package com.elandjo.snowalert.infrastructure.configuration;

import com.elandjo.snowalert.infrastructure.resource.ConditionsResource;
import com.elandjo.snowalert.infrastructure.resource.ResortsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SnowAlertApplication extends Application<SnowAlertConfiguration> {
	public static void main(String[] args) throws Exception {
		new SnowAlertApplication().run(args);
	}

	@Override
	public void run(SnowAlertConfiguration configuration, Environment environment) throws Exception {
		final ResortsResource resortsResource = new ResortsResource();
		final ConditionsResource conditionsResource = new ConditionsResource();

		environment.jersey().register(resortsResource);
		environment.jersey().register(conditionsResource);
	}

	@Override
	public String getName() {
		return "snow-alert";
	}
}