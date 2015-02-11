package com.test.dropwizard;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import org.hibernate.SessionFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/myModel")
public class MyModelResource {
	private final SessionFactory sessionFactory;

	@Inject
	public MyModelResource(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@GET
	@UnitOfWork
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers(@QueryParam("id") Optional<Long> id) {
		if (id.isPresent()) {
			return Response.ok().entity(new MyModel()).build();
		}

		return Response.ok().entity("SessionFacotry " + sessionFactory).build();
	}

}
