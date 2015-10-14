package com.elandjo.snowalert.infrastructure.resort.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("resort")
public class ResortResource {
	@Context private UriInfo uriInfo;

	@GET
	@Path("{resortId}")
	public Response resortsForRegion(@PathParam("resortId") String resortId) {
		Resort resort = new Resort("Morzine", uriInfo.getBaseUri());

		return Response.ok(resort, APPLICATION_JSON).build();
	}

}