package com.telusko.joblisting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.joblisting.PostRepository;
import com.telusko.joblisting.model.Post;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {
	
	@Autowired
	PostRepository repo;
	
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return repo.findAll();
	}
}
