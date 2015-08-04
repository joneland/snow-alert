package com.elandjo.snowalert.infrastructure.configuration;

import com.elandjo.snowalert.application.resort.GatherResortConditions;
import com.elandjo.snowalert.infrastructure.resort.FakeResortConditionsService;
import com.elandjo.snowalert.infrastructure.resource.ResortConditionsResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SnowAlertApplication extends Application<SnowAlertConfiguration> {
	public static void main(String[] args) throws Exception {
		new SnowAlertApplication().run(args);
	}

	@Override
	public void run(SnowAlertConfiguration configuration, Environment environment) throws Exception {
		final ResortConditionsResource resource = new ResortConditionsResource(
				new GatherResortConditions(new FakeResortConditionsService()));

		environment.jersey().register(resource);
	}

	@Override
	public String getName() {
		return "snow-alert";
	}
}