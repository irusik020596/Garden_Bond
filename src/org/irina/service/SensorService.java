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

import org.irina.beans.Sensor;
import org.irina.dao.RestDAO;

@Path("/sensors")
@Consumes("multipart/related")
public class SensorService {
// GET	
	   @GET
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Sensor> getSensorsAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getSensors(user, password, lotId);
	   }	
	   @GET
	   @Path("/add")
	   @Produces("text/plain")
	   public String addSensorAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("status") String status
			   )
	   {
		   return RestDAO.addSensor(user, password, lotId, name, description, type, status);
	   }	
	   @GET
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editSensorAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("status") String status
			   )
	   {
		   return RestDAO.editSensor(user, password, id, name, description, type, status);
	   }	
	   @GET
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteSensorAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteSensor(user, password, id);
	   }	
	   @GET
	   @Path("/active")
	   @Produces("text/plain")
	   public String activeSensorAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setSensorActive(user, password, id);
	   }
	   @GET
	   @Path("/passive")
	   @Produces("text/plain")
	   public String passiveSensorAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setSensorPassive(user, password, id);
	   }
// POST	   
	   @POST
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Sensor> getSensorsAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getSensors(user, password, lotId);
	   }	
	   @POST
	   @Path("/add")
	   @Produces("text/plain")
	   public String addSensorAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("status") String status
			   )
	   {
		   return RestDAO.addSensor(user, password, lotId, name, description, type, status);
	   }	
	   @POST
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editSensorAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("status") String status
			   )
	   {
		   return RestDAO.editSensor(user, password, id, name, description, type, status);
	   }	
	   @POST
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteSensorAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteSensor(user, password, id);
	   }	
	   @POST
	   @Path("/active")
	   @Produces("text/plain")
	   public String activeSensorAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setSensorActive(user, password, id);
	   }
	   @POST
	   @Path("/passive")
	   @Produces("text/plain")
	   public String passiveSensorAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setSensorPassive(user, password, id);
	   }

}