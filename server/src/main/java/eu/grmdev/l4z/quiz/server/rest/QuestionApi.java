package eu.grmdev.l4z.quiz.server.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fluent.hibernate.H;

import eu.grmdev.l4z.quiz.server.MainServlet;
import eu.grmdev.l4z.quiz.server.data.Question;

@Path("q")
public class QuestionApi {
	
	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestions() {
		try {
			List<Question> list = H.<Question> request(Question.class).list();
			if (list == null || list.size() == 0) { return Response.status(Status.NOT_FOUND).build(); }
			ObjectMapper mapper = new ObjectMapper();
			String json;
			json = mapper.writeValueAsString(list);
			return Response.ok(json).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			if (!MainServlet.DEBUG) { return Response.serverError().build(); }
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getLocalizedMessage()).build();
		}
	}
}
