package com.elandjo.snowalert.infrastructure.region.resource;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegionResourceTest {
	private RegionResource resourceUT = new RegionResource();

	private UriInfo uriInfo = mock(UriInfo.class);

	@Before
	public void
	initialise() throws URISyntaxException {
		when(uriInfo.getBaseUri()).thenReturn(new URI("http://www.test.com"));

		resourceUT.setUriInfo(uriInfo);
	}

	@Test
	public void
	returnsRegionForGivenId_WithAssociatedResorts() {
		Region expectedRegion = new Region("Rhones-Alpes", uriInfo.getBaseUri());
		expectedRegion.withResort("123", "Morzine");

		Response regionResponse = resourceUT.retrieveRegion("001");

		assertThat(regionResponse.getEntity()).isEqualTo(expectedRegion);
	}
}