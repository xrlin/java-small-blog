package test;

import models.Post;
import models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import daoMapper.PostMapper;
import daoMapper.UserMapper;

/**
 * just for test
 * @author Administrator
 *
 */
public class TestDao {

	public static void main(String[] args) {
		
		ApplicationContext actx = new FileSystemXmlApplicationContext("WebContent/WEB-INF/dispatcherServlet-servlet.xml");
		UserMapper umapper = (UserMapper) actx.getBean("userMapper", UserMapper.class);
		User u = new User();
		u.setUsername("xrlin");
		u.setPassword("110");
		umapper.addUser(u);
		umapper.deleteUserById(1);
		System.out.println(umapper.getUserByName("xrlin").get(1).getUsername());
		PostMapper pmapper = (PostMapper) actx.getBean("postMapper", PostMapper.class);
		Post p = new Post();
		p.setContent("haha");
		p.setTitle("haah");
		p.setUserId(2);
		pmapper.addPost(p);
		pmapper.getPostById(2);
		System.out.println(pmapper.getPostById(2));
	}
}
