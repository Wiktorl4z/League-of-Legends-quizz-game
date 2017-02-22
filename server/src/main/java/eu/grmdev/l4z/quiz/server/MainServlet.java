package eu.grmdev.l4z.quiz.server;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 7291196543718359940L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			ServletOutputStream os = resp.getOutputStream();
			os.write("Hello from Lol Quiz Server ;)  V: 0.0.0.0001".getBytes());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
