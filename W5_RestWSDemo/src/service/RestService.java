package service;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.UserManager;
import model.User;


@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

	@EJB
	UserManager userManager;
	
	UserService userService = new UserService();
	
	//http://localhost:8080/W5_RestWSDemo/resources/MyRestService/sayHello
	@GET
	@Path("/sayHello")
	public String getHello() {
		return "Hello";
	}
	
	//http://localhost:8080/W5_RestWSDemo/resources/MyRestService/echo?message=TestingMessage
	@GET
	@Path("/echo")
	public Response getEchoMessage(@QueryParam("message") String msg) {
		return Response.ok("Your message was : " + msg).build();
	}
	
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		return new User("1", "John", 33);
	}
	
	@GET
	@Path("/readusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers(){
		List<User> userList = userService.getAllUsers();
		return userList;
	}
	
	@GET
	@Path("/maxcount")
	@Produces(MediaType.TEXT_HTML)
	public String getMaxUserCount() {
		return "<h1>Total user count is : " + userManager.getMaxUserCount() + "</h1>";
	}
	
	@POST
	@Path("/adduser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		User usrRes = userService.createUser(user);
		return usrRes;
	}
	
	@PUT
	@Path("/updateuser/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("userId") String id, User user) {
		user.setId(id);
		User usrRes =  userService.updateUser(user);
		return usrRes;
	}	
	
	@DELETE
	@Path("/deleteuser/{userId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("userId") String id) {
		userService.removeUser(id);
		return "Deleted";
	}
	
	@GET
	@Path("/currentcount")
	@Produces(MediaType.TEXT_HTML)
	public String getCurrentUserCount() {
		return "<h1>Current user count is : " + userManager.getCurrentUserCount() + "</h1>";
	}

}
