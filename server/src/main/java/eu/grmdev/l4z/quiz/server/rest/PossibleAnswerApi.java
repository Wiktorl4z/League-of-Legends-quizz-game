package eu.grmdev.l4z.quiz.server.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fluent.hibernate.H;

import eu.grmdev.l4z.quiz.server.data.AnswerType;
import eu.grmdev.l4z.quiz.server.data.PossibleAnswer;

@Path("a")
public class PossibleAnswerApi {
	@Path("/names")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNames() {
		List<PossibleAnswer> list = H.<PossibleAnswer> request(PossibleAnswer.class).eq("answerType", AnswerType.NAMES).list();
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(list);
			return Response.ok(json).build();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			// return Response.serverError().build();
			return Response.status(500).entity(e.getLocalizedMessage()).build();
		}
	}
	
	@Path("/surnames")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSurNames() {
		List<PossibleAnswer> list = H.<PossibleAnswer> request(PossibleAnswer.class).eq("answerType", AnswerType.SURNAMES).list();
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(list);
			return Response.ok(json).build();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
			// return Response.serverError().build();
			return Response.status(500).entity(e.getLocalizedMessage()).build();
		}
	}
}
