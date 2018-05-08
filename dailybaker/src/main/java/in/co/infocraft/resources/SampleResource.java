package in.co.infocraft.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import in.co.infocraft.dto.SampleDTO;
import in.co.infocraft.models.UserModel;
import in.co.infocraft.services.UserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {
	
	private final UserService userService;
	
	public SampleResource(UserService userService) {
		this.userService = userService;
	}
	
	@GET
	@Timed
	@Path("/login")
    public SampleDTO test(@QueryParam("id") int id) {
		
		UserModel user = userService.getUser(id);
		
		SampleDTO sample = new SampleDTO();
		sample.setName(user.getUsername());
        return sample;
    }

}
