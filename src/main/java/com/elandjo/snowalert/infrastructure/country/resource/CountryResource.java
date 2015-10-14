package com.elandjo.snowalert.infrastructure.country.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("country")
public class CountryResource {
	@Context private UriInfo uriInfo;

	@GET
	@Path("{countryId}")
	public Response specificCountry() {
		Country country = new Country("France", uriInfo.getBaseUri());
		country.withRegion("123", "Rhone-Alpes");

		return Response.ok(country, APPLICATION_JSON).build();
	}

	protected void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
}