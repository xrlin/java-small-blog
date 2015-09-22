package daoMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import models.User;

public interface UserMapper {

	@Select("select * from users where username=#{username}")
	ArrayList<User> getUserByName(String username);
	
	@Select("select * from users where id=#{id}")
	User getUserById(int id);
	
	@Insert("insert into users(username, password) values (#{username}, #{password})")
	void addUser(User u);
	
	@Delete("delete from users where id=#{id}")
	void deleteUserById(int id);
}
