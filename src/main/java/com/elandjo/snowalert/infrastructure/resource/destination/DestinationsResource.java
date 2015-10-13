package com.elandjo.snowalert.infrastructure.resource.destination;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("destinations")
public class DestinationsResource {
	@Context private UriInfo uriInfo;

	@GET
	public Response allCountries() {
		Countries countries = new Countries();
		countries.add(new Country("France", uriInfo.getRequestUri()));

		return Response.ok(countries, APPLICATION_JSON).build();
	}

	@GET
	@Path("{country}")
	public Response regionsForCountry(@PathParam("country") String country) {
		Regions regions = new Regions();
		regions.add(new Region("Rhone-Alpes", uriInfo.getRequestUri()));

		return Response.ok(regions, APPLICATION_JSON).build();
	}

	@GET
	@Path("{country}/{region}")
	public Response resortsForRegion(@PathParam("country") String country, @PathParam("region") String region) {
		Resorts resorts = new Resorts();
		resorts.add(new Resort("Morzine", 1234, uriInfo.getBaseUri()));

		return Response.ok(resorts, APPLICATION_JSON).build();
	}

	protected void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
}