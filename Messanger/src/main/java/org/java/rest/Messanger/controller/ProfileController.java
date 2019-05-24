package org.java.rest.Messanger.controller;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.model.ParamQualifier;
import org.java.rest.Messanger.Service.ProfileService;
import org.java.rest.Messanger.pojo.Messages;
import org.java.rest.Messanger.pojo.Profile;

@Path("/profile")
public class ProfileController {

	ProfileService pService = new ProfileService();
	Profile profile = new Profile();
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addProfile")
	public Profile saveProfile (Profile profiles) {
		pService.saveProfileService(profiles);
		return profiles;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allProfiles")
	public List<Profile> getAllProfiles() {
		
		return pService.getProfileService();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{profileName}")
	public Profile getProfileFromName(@PathParam(value = "profileName") String profileName) {
		return pService.getProfileFromName(profileName);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateProfile")
	public Profile updateProfile(Profile profile) {
		return pService.updateProfileService(profile);
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteProfile/{id}")
	public Profile deleteProfile(@PathParam(value = "id") int id) {
		return pService.deleteProfileService(id);
	}
}
