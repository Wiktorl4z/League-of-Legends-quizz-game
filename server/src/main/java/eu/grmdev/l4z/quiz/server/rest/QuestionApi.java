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

import eu.grmdev.l4z.quiz.server.data.Question;

@Path("q")
public class QuestionApi {
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestions() {
		List<Question> list = H.<Question> request(Question.class).list();
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
