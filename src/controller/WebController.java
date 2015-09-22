package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import daoMapper.PostMapper;
import daoMapper.UserMapper;
import interceptor.LoginRequired;
import models.Post;
import models.User;
import validators.PostValidator;
import validators.UserValidator;

@Controller
@RequestMapping("/")
public class WebController {

	//@Autowired
	//private UserMapper umapper;
	
	@Autowired
	private PostMapper pmapper;
	
	@Autowired
	private UserMapper umapper;
	
	@RequestMapping(value={"/index"})
	public ModelAndView index(@RequestParam(value="page", required=false, defaultValue="1") int num){
		PageHelper.startPage(num, 3);
		
		ArrayList<Post> posts = pmapper.getPosts();
		
		Page<Post> p = (Page<Post>)posts;
		int currentPage = p.getPageNum();	//current page
		int totalNum = (int) p.getTotal();	//total page
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("currentPage", currentPage);
		mv.addObject("totalNum", totalNum);
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public String login(@ModelAttribute("user") @Validated User u, BindingResult result,HttpSession session){
		new UserValidator().validate(u, result);
		if(! result.hasErrors()){
			if(!umapper.getUserByName(u.getUsername()).isEmpty())
				if(!umapper.getUserByName(u.getUsername()).get(0).getPassword().equals(u.getPassword()))
					return "login";
				else{
					
				}
			else{
				return "login";
			}
			session.setAttribute("user", u.getUsername());
			return "redirect:/index";
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/index";
	}
	
	@LoginRequired
	@RequestMapping("/admin")
	public String admin(HttpSession session){
		if(session.getAttribute("user") == null){
			return "redirect:/login";
		}
		return "admin/admin";
	}
	
	@ModelAttribute("post")
	public Post getPost() {
		return new Post();
	}
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	@LoginRequired
	@RequestMapping(value="/admin/addpost", method={RequestMethod.POST})
	public String addPost(@ModelAttribute("post") @Validated Post p, BindingResult result, HttpSession session){
		
		if(session.getAttribute("user") == null){
			return "redirect:/login";
		}
		
		new PostValidator().validate(p, result);
		if (!result.hasErrors()){
			
			pmapper.addPost(p);
			return "redirect:/admin";
		}
		return "redirect:/admin";
	}
	
	@LoginRequired
	@RequestMapping(value="/admin/postlist", method={RequestMethod.GET})
	public ModelAndView getPostList(){
		ArrayList<Post> posts = pmapper.getPosts();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/postlist");
		mv.addObject("posts", posts);
		return mv;
	}
	
	@LoginRequired
	@RequestMapping(value="/admin/delete/post/{id}")
	public String delete(@PathVariable("id") int id){
		pmapper.deletePostById(id);
		return "redirect:/admin/postlist";
	}
	
	@LoginRequired
	@RequestMapping(value="/admin/edit/post/{id}")
	public ModelAndView edit(@PathVariable("id") int id){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("post", pmapper.getPostById(id));
		mv.setViewName("admin/edit");
		return mv;
	}
	
	@LoginRequired
	@RequestMapping(value="/admin/update/post")
	public String updatePost(@ModelAttribute("post") @Validated Post p){
		pmapper.updatePost(p);
		return "redirect:/admin/postlist";
	}
}
