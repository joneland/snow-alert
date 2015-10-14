package com.elandjo.snowalert.infrastructure.country.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("country")
public class CountryResource {
	@Context private UriInfo uriInfo;

	@GET
	public Response allCountries() {
		Countries countries = new Countries(uriInfo.getBaseUri());
		countries.withCountry("123", "France");

		return Response.ok(countries, APPLICATION_JSON).build();
	}

	@GET
	@Path("{countryId}")
	public Response retrieveCountry(@PathParam("countryId") String countryId) {
		Country country = new Country("France", uriInfo.getBaseUri());
		country.withRegion("123", "Rhone-Alpes");

		return Response.ok(country, APPLICATION_JSON).build();
	}

	protected void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
}