package com.elandjo.snowalert.infrastructure.resort.resource;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResortResourceTest {
	private ResortResource resourceUT = new ResortResource();

	private UriInfo uriInfo = mock(UriInfo.class);

	@Before
	public void
	initialise() throws URISyntaxException {
		when(uriInfo.getBaseUri()).thenReturn(new URI("http://www.test.com"));

		resourceUT.setUriInfo(uriInfo);
	}

	@Test
	public void
	returnsResortForGivenId() {
		Resort expectedResort = new Resort("Morzine", uriInfo.getBaseUri());

		Response resortResponse = resourceUT.retrieveResort("001");

		assertThat(resortResponse.getEntity()).isEqualTo(expectedResort);
	}
}