package daoMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import models.Post;

public interface PostMapper {
	
	@Select("select * from post where id=#{id}")
	Post getPostById(int id);
	
	@Delete("delete from post where id=#{id}")
	void deletePostById(int id);
	
	@Insert("insert into post(title, content) values (#{title}, #{content})")
	void addPost(Post p);
	
	@Insert("insert into post(title, content, userId) values (#{title}, #{content}, #{userId})")
	void addPostWithUserId(Post p);
	
	@Select("select * from post")
	ArrayList<Post> getPosts();
	
	@Update("update post set title=#{title}, content=#{content} where id=#{id}")
	void updatePost(Post p);
}
