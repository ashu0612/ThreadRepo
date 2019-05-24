package org.java.rest.Messanger.controller;

import java.util.List;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.java.rest.Messanger.Service.MessangerService;
//import org.java.rest.Messanger.pojo.Comments;
import org.java.rest.Messanger.pojo.Messages;

import antlr.StringUtils;

@Path("/Message")
//@Singleton if we use this then request will be share every time 
//new instance will not formed when new request comes.
//default:request scope resource life cycle
public class MessageController {
	MessangerService servcie = new MessangerService();
	Messages messages = new Messages();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMessage")
	//this will use responseBUilder build() method 
	//this will be empty whenever the new request comes.
	public Response saveMessage(Messages message) {
		System.out.println("inside post method");
		servcie.saveMessageService(message);
		return Response.status(201).entity(message).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/messages")
	//we can create one separate bean and pass all these query params
	//as members to that bean and access them to the method variables.
	//e.g. private @QueryParam("start") int start in MessageBean
	public List<Messages> getMessages(@QueryParam("authorName") String authorName,
			                          @QueryParam("start") int start,
			                          @QueryParam("size") int size) {
		if(authorName != null) {
			return servcie.getMessagesFromFilter(authorName);
		}
		if (size >0 && start >=0) {
			return servcie.getmessagesFromStartAndSize(start, size);
		}
		return servcie.getMessageService();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/message/{messageId}")
	public Messages getMessageFromId(@PathParam(value = "messageId") int id) {
		return servcie.getMessageServiceById(id);
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteMessage/{messageId}")
	public Messages deleteMessageFromId(@PathParam(value = "messageId") int id) {
		return servcie.deleteMessageService(id);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateMessage")
	public Messages updatedMessage(Messages message) {
		servcie.updateMessageService(message);
		return message;
	}
/*	
	@Path("/{messageId}/comments")
	public Comments getComments() {
		return new Comments();
	}*/
	
}
