package com.elandjo.snowalert.infrastructure.country.resource;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryResourceTest {
	private CountryResource resourceUT = new CountryResource();

	private UriInfo uriInfo = mock(UriInfo.class);

	@Before public void
	initialise() throws URISyntaxException {
		when(uriInfo.getBaseUri()).thenReturn(new URI("http://www.test.com"));

		resourceUT.setUriInfo(uriInfo);
	}

	@Test public void
	returnsCountryForGivenId_WithAssociatedRegions() {
		Country expectedCountry = new Country("France", uriInfo.getBaseUri());
		expectedCountry.withRegion("123", "Rhone-Alpes");

		Response countryResponse = resourceUT.retrieveCountry("001");

		assertThat(countryResponse.getEntity()).isEqualTo(expectedCountry);
	}
}