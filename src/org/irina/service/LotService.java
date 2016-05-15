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

import org.irina.beans.Item;
import org.irina.dao.RestDAO;

@Path("/lots")
@Consumes("multipart/related")
public class LotService {
	   @GET
	   @Path("/list")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	   	@Consumes("application/x-www-form-urlencoded")
	   @Produces(MediaType.APPLICATION_JSON/*APPLICATION_XML*/)
	   public List<Item> getLotsAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password
			   )
	   {
		   return RestDAO.getLots(user, password);
	   }	
	   @POST
	   @Path("/list")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces(MediaType.APPLICATION_JSON/*APPLICATION_XML*/)
	   public List<Item> getLotsAsPost(
//			   MultivaluedMap<String, String> params
		   		@DefaultValue("") @QueryParam("user") String user,
		   		@DefaultValue("") @QueryParam("password") String password
			   )
	   {
//	       String user = params.getFirst("user");
//	       String password = params.getFirst("password");
	 	   return RestDAO.getLots(user, password);
	   }	
	   @GET
	   @Path("/add")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	   	@Consumes("application/x-www-form-urlencoded")
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String addLotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("description") String description

			   )
	   {
		   return RestDAO.addLot(user, password, description);
	   }	
	   @POST
	   @Path("/add")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String addLotAsPost(
//			   MultivaluedMap<String, String> params
		   		@DefaultValue("") @QueryParam("user") String user,
		   		@DefaultValue("") @QueryParam("password") String password,
		   		@DefaultValue("") @QueryParam("description") String description
			   )
	   {
//	       String user = params.getFirst("user");
//	       String password = params.getFirst("password");
//	       String description = params.getFirst("description");
	 	   return RestDAO.addLot(user, password, description);
	   }	
	   @GET
	   @Path("/edit")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	   	@Consumes("application/x-www-form-urlencoded")
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String editLotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("description") String description

			   )
	   {
		   return RestDAO.editLot(user, password, id, description);
	   }	
	   @POST
	   @Path("/edit")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String editLotAsPost(
//			   MultivaluedMap<String, String> params
		   		@DefaultValue("") @QueryParam("user") String user,
		   		@DefaultValue("") @QueryParam("password") String password,
		   		@DefaultValue("") @QueryParam("id") String id,
		   		@DefaultValue("") @QueryParam("description") String description
			   )
	   {
//	       String user = params.getFirst("user");
//	       String password = params.getFirst("password");
//	       String id = params.getFirst("id");
//	       String description = params.getFirst("description");
	 	   return RestDAO.editLot(user, password, id, description);
	   }	
	   @GET
	   @Path("/delete")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	   	@Consumes("application/x-www-form-urlencoded")
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String deleteLotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteLot(user, password, id);
	   }	
	   @POST
	   @Path("/delete")
//	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   @Produces("text/plain"/*MediaType.APPLICATION_JSON*//*APPLICATION_XML*/)
	   public String deleteLotAsPost(
//			   MultivaluedMap<String, String> params
		   		@DefaultValue("") @QueryParam("user") String user,
		   		@DefaultValue("") @QueryParam("password") String password,
		   		@DefaultValue("") @QueryParam("id") String id
			   )
	   {
//	       String user = params.getFirst("user");
//	       String password = params.getFirst("password");
//	       String id = params.getFirst("id");
	 	   return RestDAO.deleteLot(user, password, id);
	   }	
	   
}