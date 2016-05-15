package org.irina.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.irina.beans.Problem;
import org.irina.dao.RestDAO;

@Path("/problems")
@Consumes("multipart/related")
public class ProblemService {
	   @GET
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON/*APPLICATION_XML*/)
	   public List<Problem> getActiveProblemsAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password
			   )
	   {
		   return RestDAO.getActiveProblems(user, password);
	   }	
	   @GET
	   @Path("/check")
	   @Produces("text/plain")
	   public String checkProblemAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.checkProblem(user, password, id);
	   }	
	   
	   @POST
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON/*APPLICATION_XML*/)
	   public List<Problem> getActiveProblemsAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password
			   )
	   {
		   return RestDAO.getActiveProblems(user, password);
	   }	
	   @POST
	   @Path("/check")
	   @Produces("text/plain")
	   public String checkProblemAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.checkProblem(user, password, id);
	   }	
	   
}