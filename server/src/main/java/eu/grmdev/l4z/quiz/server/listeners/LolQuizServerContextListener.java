package eu.grmdev.l4z.quiz.server.listeners;

import static eu.grmdev.l4z.quiz.utils.CLogger.closeLoggers;
import static eu.grmdev.l4z.quiz.utils.CLogger.info;
import static eu.grmdev.l4z.quiz.utils.CLogger.initLogger;
import static eu.grmdev.l4z.quiz.utils.CLogger.warn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import eu.grmdev.l4z.quiz.server.database.DatabaseHandler;

public class LolQuizServerContextListener implements ServletContextListener {
	/*
	 * (non-Javadoc)
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initLogger();
		info("Lol Quiz Server App initializing ...");
		DatabaseHandler.initConnection();
		info("Connection initialized");
	}
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		info("Lol Quiz Server App closing ...");
		DatabaseHandler.closeConnection();
		try {
			AbandonedConnectionCleanupThread.shutdown();
		}
		catch (InterruptedException e) {
			warn("SEVERE problem cleaning up: " + e.getMessage());
			e.printStackTrace();
		}
		closeLoggers();
	}
}
