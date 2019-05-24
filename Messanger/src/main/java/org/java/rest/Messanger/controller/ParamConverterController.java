package org.java.rest.Messanger.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.java.rest.Messanger.converters.TestComparator;
//this class denotes that how custm comparator works.
@Path("/paramConverters")
public class ParamConverterController {

	@GET
	@Path("/{value}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamConverter(@PathParam("value") TestComparator value) {
		return value.toString();
	}
	
}
