/*package org.java.rest.Messanger.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.java.rest.Messanger.DAO.CommentDAO;
import org.java.rest.Messanger.pojo.Comments;

@Path("/")
public class CommentController {

	CommentDAO cDao = new CommentDAO();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/saveComment")
	public void saveComments(Comments comment) {
		cDao.saveComments(comment);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "test";
	}
}
*/