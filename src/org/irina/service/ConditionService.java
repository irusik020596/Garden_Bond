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

import org.irina.beans.Condition;
import org.irina.dao.RestDAO;

@Path("/conditions")
@Consumes("multipart/related")
public class ConditionService {
// GET	
	   @GET
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Condition> getConditionsAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String ruleId
			   )
	   {
		   return RestDAO.getConditions(user, password, ruleId);
	   }	
	   @GET
	   @Path("/add")
	   @Produces("text/plain")
	   public String addConditionAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("ruleid") String ruleId,
			   		@DefaultValue("") @QueryParam("sensorid") String sensorId,
			   		@DefaultValue("") @QueryParam("operation") String operation,
			   		@DefaultValue("") @QueryParam("limit") String limit
			   )
	   {
		   return RestDAO.addCondition(user, password, ruleId, sensorId, operation, limit);
	   }	
	   @GET
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editConditionAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("sensorid") String sensorId,
			   		@DefaultValue("") @QueryParam("operation") String operation,
			   		@DefaultValue("") @QueryParam("limit") String limit
			   )
	   {
		   return RestDAO.editCondition(user, password, id, sensorId, operation, limit);
	   }	
	   @GET
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteConditionAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteCondition(user, password, id);
	   }	
// POST	
	   @POST
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Condition> getConditionsAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String ruleId
			   )
	   {
		   return RestDAO.getConditions(user, password, ruleId);
	   }	
	   @POST
	   @Path("/add")
	   @Produces("text/plain")
	   public String addConditionAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("ruleid") String ruleId,
			   		@DefaultValue("") @QueryParam("sensorid") String sensorId,
			   		@DefaultValue("") @QueryParam("operation") String operation,
			   		@DefaultValue("") @QueryParam("limit") String limit
			   )
	   {
		   return RestDAO.addCondition(user, password, ruleId, sensorId, operation, limit);
	   }	
	   @POST
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editConditionAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("sensorid") String sensorId,
			   		@DefaultValue("") @QueryParam("operation") String operation,
			   		@DefaultValue("") @QueryParam("limit") String limit
			   )
	   {
		   return RestDAO.editCondition(user, password, id, sensorId, operation, limit);
	   }	
	   @POST
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteConditionAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteCondition(user, password, id);
	   }
}
