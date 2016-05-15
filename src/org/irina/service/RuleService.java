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

import org.irina.beans.Rule;
import org.irina.dao.RestDAO;

@Path("/rules")
@Consumes("multipart/related")
public class RuleService {
// GET	
	   @GET
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Rule> getRulesAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getRules(user, password, lotId);
	   }	
	   @GET
	   @Path("/add")
	   @Produces("text/plain")
	   public String addRuleAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("smsnote") String smsnote,
			   		@DefaultValue("") @QueryParam("emailnote") String emailnote,
			   		@DefaultValue("") @QueryParam("type") String type
			   )
	   {
		   return RestDAO.addRule(user, password, lotId, name, description, smsnote, emailnote, type);
	   }	
	   @GET
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editRuleAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("smsnote") String smsnote,
			   		@DefaultValue("") @QueryParam("emailnote") String emailnote,
			   		@DefaultValue("") @QueryParam("type") String type
			   )
	   {
		   return RestDAO.editRule(user, password, id, name, description, smsnote, emailnote, type);
	   }	
	   @GET
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteRuleAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteRule(user, password, id);
	   }	
	// POST	
	   @POST
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Rule> getRulesAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getRules(user, password, lotId);
	   }	
	   @POST
	   @Path("/add")
	   @Produces("text/plain")
	   public String addRuleAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("smsnote") String smsnote,
			   		@DefaultValue("") @QueryParam("emailnote") String emailnote,
			   		@DefaultValue("") @QueryParam("type") String type
			   )
	   {
		   return RestDAO.addRule(user, password, lotId, name, description, smsnote, emailnote, type);
	   }	
	   @POST
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editRuleAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("smsnote") String smsnote,
			   		@DefaultValue("") @QueryParam("emailnote") String emailnote,
			   		@DefaultValue("") @QueryParam("type") String type
			   )
	   {
		   return RestDAO.editRule(user, password, id, name, description, smsnote, emailnote, type);
	   }	
	   @POST
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteRuleAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteRule(user, password, id);
	   }
}	   