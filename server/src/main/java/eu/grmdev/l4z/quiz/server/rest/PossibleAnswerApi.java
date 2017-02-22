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
import eu.grmdev.l4z.quiz.server.data.AnswerType;
import eu.grmdev.l4z.quiz.server.data.PossibleAnswer;

@Path("a")
public class PossibleAnswerApi {
	
	@Path("names")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNames() {
		return getPPosAnswers(AnswerType.NAMES);
	}
	
	@Path("surnames")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSurNames() {
		return getPPosAnswers(AnswerType.SURNAMES);
	}
	
	private Response getPPosAnswers(AnswerType answerType) {
		try {
			List<PossibleAnswer> list = H.<PossibleAnswer> request(PossibleAnswer.class).eq("answerType", answerType).list();
			if (list == null || list.size() == 0) { return Response.status(Status.NOT_FOUND).build(); }
			String[] values = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				PossibleAnswer a = list.get(i);
				values[i] = a.getAnswer();
			}
			ObjectMapper mapper = new ObjectMapper();
			String json;
			json = mapper.writeValueAsString(values);
			return Response.ok(json).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			if (!MainServlet.DEBUG) { return Response.serverError().build(); }
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getLocalizedMessage()).build();
		}
	}
}
