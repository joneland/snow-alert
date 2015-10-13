package com.elandjo.snowalert.infrastructure.resource.destination;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.Status.OK;
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
	supportedCountries() {
		Countries expectedCountries = new Countries();
		expectedCountries.add(new Country("France", uriInfo.getRequestUri()));

		Response countriesResponse = destinationsResource.allCountries();

		assertThat(countriesResponse.getEntity()).isEqualTo(expectedCountries);
		assertThat(countriesResponse.getStatus()).isEqualTo(OK.getStatusCode());
	}

	@Test public void
	supportedRegions_ForGivenCountry() {
		Regions expectedRegions = new Regions();
		expectedRegions.add(new Region("Rhone-Alpes", uriInfo.getRequestUri()));

		Response regionsResponse = destinationsResource.regionsForCountry("France");

		assertThat(regionsResponse.getEntity()).isEqualTo(expectedRegions);
		assertThat(regionsResponse.getStatus()).isEqualTo(OK.getStatusCode());
	}

	@Test public void
	supportedResorts_ForGivenRegion() {
		Resorts expectedResorts = new Resorts();
		expectedResorts.add(new Resort("Morzine", 1234, uriInfo.getBaseUri()));

		Response resortsResponse = destinationsResource.resortsForRegion("France", "Rhone-Alpes");

		assertThat(resortsResponse.getEntity()).isEqualTo(expectedResorts);
		assertThat(resortsResponse.getStatus()).isEqualTo(OK.getStatusCode());
	}
}