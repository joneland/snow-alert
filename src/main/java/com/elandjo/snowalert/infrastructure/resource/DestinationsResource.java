package com.elandjo.snowalert.infrastructure.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("destinations")
public class DestinationsResource {
	@Context private UriInfo uriInfo;

	protected void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}

	@GET
	@Produces(APPLICATION_JSON)
	public Countries allCountries() {
		Countries countries = new Countries();
		countries.add(new Country("France", uriInfo.getRequestUri()));
		return countries;
	}

	@GET
	@Path("{country}")
	@Produces(APPLICATION_JSON)
	public Regions regionsForCountry(@PathParam("country") String country) {
		Regions regions = new Regions();
		regions.add(new Region("Rhone-Alpes", uriInfo.getRequestUri()));
		return regions;
	}

	@GET
	@Path("{country}/{region}")
	@Produces(APPLICATION_JSON)
	public Resorts resortsForRegion(@PathParam("country") String country, @PathParam("region") String region) {
		Resorts resorts = new Resorts();
		resorts.add(new Resort("Morzine", 1234, uriInfo.getBaseUri()));
		return resorts;
	}
}