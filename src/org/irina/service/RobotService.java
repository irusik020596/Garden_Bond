package org.irina.service;

import java.util.List;
import org.irina.beans.Robot;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;

//import org.irina.beans.Sensor;
import org.irina.dao.RestDAO;

@Path("/robots")
@Consumes("multipart/related")
public class RobotService {
// GET	
	   @GET
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Robot> getRobotsAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getRobots(user, password, lotId);
	   }	
	   @GET
	   @Path("/add")
	   @Produces("text/plain")
	   public String addRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("host") String host,
			   		@DefaultValue("") @QueryParam("port") String port,
			   		@DefaultValue("") @QueryParam("status") String status,
			   		@DefaultValue("") @QueryParam("status") String state
			   )
	   {
		   return RestDAO.addRobot(user, password, lotId, name, description, type, host, port, status, state);
	   }	
	   @GET
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("host") String host,
			   		@DefaultValue("") @QueryParam("port") String port,
			   		@DefaultValue("") @QueryParam("status") String status,
			   		@DefaultValue("") @QueryParam("status") String state
			   )
	   {
		   return RestDAO.editRobot(user, password, id, name, description, type, host, port, status, state);
	   }	
	   @GET
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteRobot(user, password, id);
	   }
	   @GET
	   @Path("/active")
	   @Produces("text/plain")
	   public String activeRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotActive(user, password, id);
	   }
	   @GET
	   @Path("/passive")
	   @Produces("text/plain")
	   public String passiveRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotPassive(user, password, id);
	   }
	   @GET
	   @Path("/on")
	   @Produces("text/plain")
	   public String onRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotOn(user, password, id);
	   }
	   @GET
	   @Path("/off")
	   @Produces("text/plain")
	   public String offRobotAsGet(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotOff(user, password, id);
	   }
// POST
	   @POST
	   @Path("/list")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Robot> getRobotsAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId
			   )
	   {
		   return RestDAO.getRobots(user, password, lotId);
	   }	
	   @POST
	   @Path("/add")
	   @Produces("text/plain")
	   public String addRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("lotid") String lotId,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("host") String host,
			   		@DefaultValue("") @QueryParam("port") String port,
			   		@DefaultValue("") @QueryParam("status") String status,
			   		@DefaultValue("") @QueryParam("status") String state
			   )
	   {
		   return RestDAO.addRobot(user, password, lotId, name, description, type, host, port, status, state);
	   }	
	   @POST
	   @Path("/edit")
	   @Produces("text/plain")
	   public String editRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id,
			   		@DefaultValue("") @QueryParam("name") String name,
			   		@DefaultValue("") @QueryParam("description") String description,
			   		@DefaultValue("") @QueryParam("type") String type,
			   		@DefaultValue("") @QueryParam("host") String host,
			   		@DefaultValue("") @QueryParam("port") String port,
			   		@DefaultValue("") @QueryParam("status") String status,
			   		@DefaultValue("") @QueryParam("status") String state
			   )
	   {
		   return RestDAO.editRobot(user, password, id, name, description, type, host, port, status, state);
	   }	
	   @POST
	   @Path("/delete")
	   @Produces("text/plain")
	   public String deleteRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.deleteRobot(user, password, id);
	   }
	   @POST
	   @Path("/active")
	   @Produces("text/plain")
	   public String activeRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotActive(user, password, id);
	   }
	   @POST
	   @Path("/passive")
	   @Produces("text/plain")
	   public String passiveRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotPassive(user, password, id);
	   }
	   @POST
	   @Path("/on")
	   @Produces("text/plain")
	   public String onRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotOn(user, password, id);
	   }
	   @POST
	   @Path("/off")
	   @Produces("text/plain")
	   public String offRobotAsPost(
			   		@DefaultValue("") @QueryParam("user") String user,
			   		@DefaultValue("") @QueryParam("password") String password,
			   		@DefaultValue("") @QueryParam("id") String id

			   )
	   {
		   return RestDAO.setRobotOff(user, password, id);
	   }

}	   