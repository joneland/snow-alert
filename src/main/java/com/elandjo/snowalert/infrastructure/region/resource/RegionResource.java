package com.elandjo.snowalert.infrastructure.region.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("region")
public class RegionResource {
	@Context private UriInfo uriInfo;

	@GET
	@Path("{regionId}")
	public Response retrieveRegion(@PathParam("regionId") String regionId) {
		Region region = new Region("Rhones-Alpes", uriInfo.getBaseUri());
		region.withResort("123", "Morzine");

		return Response.ok(region, APPLICATION_JSON).build();
	}

	protected void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}
}