package com.elandjo.snowalert.infrastructure.configuration;

import com.elandjo.snowalert.infrastructure.country.resource.CountryResource;
import com.elandjo.snowalert.infrastructure.region.resource.RegionResource;
import com.elandjo.snowalert.infrastructure.resort.resource.ResortResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SnowAlertApplication extends Application<SnowAlertConfiguration> {
	public static void main(String[] args) throws Exception {
		new SnowAlertApplication().run(args);
	}

	@Override
	public void run(SnowAlertConfiguration configuration, Environment environment) throws Exception {
		final CountryResource countryResource = new CountryResource();
		final RegionResource regionResource = new RegionResource();
		final ResortResource resortResource = new ResortResource();

		environment.jersey().register(countryResource);
		environment.jersey().register(regionResource);
		environment.jersey().register(resortResource);
	}

	@Override
	public String getName() {
		return "snow-alert";
	}
}