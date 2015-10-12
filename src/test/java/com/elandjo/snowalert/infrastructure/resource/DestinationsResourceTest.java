package com.elandjo.snowalert.infrastructure.resource;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DestinationsResourceTest {
	private UriInfo uriInfo = mock(UriInfo.class);

	private DestinationsResource destinationsResource;

	@Before public void
	initialise() throws URISyntaxException {
		when(uriInfo.getRequestUri()).thenReturn(new URI("http://www.test.com"));

		destinationsResource = new DestinationsResource();
		destinationsResource.setUriInfo(uriInfo);
	}

	@Test public void
	returnsSupportedCountries() {
		Countries countries = destinationsResource.allCountries();

		Countries expectedCountries = new Countries();
		Country france = new Country("France", uriInfo.getRequestUri());
		expectedCountries.add(france);

		assertThat(countries).isEqualTo(expectedCountries);
	}

}