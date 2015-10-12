package com.elandjo.snowalert.infrastructure.resource;

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

	@Before
	public void
	initialise() throws URISyntaxException {
		when(uriInfo.getRequestUri()).thenReturn(new URI("http://www.test.com/destinations"));
		when(uriInfo.getBaseUri()).thenReturn(new URI("http://www.test.com"));

		destinationsResource = new DestinationsResource();
		destinationsResource.setUriInfo(uriInfo);
	}

	@Test public void
	returnsSupportedCountries() {
		Countries expectedCountries = new Countries();
		expectedCountries.add(new Country("France", uriInfo.getRequestUri()));

		Countries countries = destinationsResource.allCountries();

		assertThat(countries).isEqualTo(expectedCountries);
	}

	@Test public void
	returnsSupportedRegionsForGivenCountry() {
		Regions expectedRegions = new Regions();
		expectedRegions.add(new Region("Rhone-Alpes", uriInfo.getRequestUri()));

		Regions regions = destinationsResource.regionsForCountry("France");

		assertThat(regions).isEqualTo(expectedRegions);
	}

	@Test public void
	returnsSupportedResortsForGivenRegion() {
		Resorts expectedResorts = new Resorts();
		expectedResorts.add(new Resort("Morzine", 1234, uriInfo.getBaseUri()));

		Resorts resorts = destinationsResource.resortsForRegion("France", "Rhone-Alpes");

		assertThat(resorts).isEqualTo(expectedResorts);
	}
}