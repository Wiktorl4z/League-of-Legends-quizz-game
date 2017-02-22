package eu.grmdev.l4z.quiz.server.database;

import com.github.fluent.hibernate.cfg.Fluent;

import eu.grmdev.l4z.quiz.server.data.PossibleAnswer;
import eu.grmdev.l4z.quiz.server.data.Question;

public final class DatabaseHandler {
	private static volatile boolean configured;
	
	private DatabaseHandler() {}
	
	public static void initConnection() {
		if (configured) { return; }
		createSessionFactory();
	}
	
	private static synchronized void createSessionFactory() {
		if (configured) { return; }
		@SuppressWarnings("rawtypes")
		Class[] classes = new Class[]{Question.class, PossibleAnswer.class};
		Fluent.factory().annotatedClasses(classes).build();
		configured = true;
	}
	
	public static void closeConnection() {
		Fluent.factory().close();
	}
}
