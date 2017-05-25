package com.monsterlin.time;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GrabDataTaskListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		new TimerManager();
	}

}
