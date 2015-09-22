package utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import daoMapper.PostMapper;

public class Factory {
	
	public static final ApplicationContext ACTX = new FileSystemXmlApplicationContext("WEB-INF/dispatcherServlet-servlet.xml");
	
	public static void UserMapper(){};
	
	/**
	 * a method to get the postMapper object so can deal with the database later
	 * @return
	 */
	public static PostMapper getPostMapper(){
		PostMapper pmapper = (PostMapper) ACTX.getBean("postMapper", PostMapper.class);
		return pmapper;
	}

}
