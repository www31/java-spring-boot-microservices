package com.telusko.quizapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}") 
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("addQuestions")
	public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions) {
		int i = 0;
		for (Question question : questions) {
			i++;
			LOGGER.info(this.getClass().getCanonicalName() + " " + i +" - {}", question.toString());
		}
		return questionService.addQuestions(questions);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		LOGGER.info(this.getClass().getCanonicalName() + " - {}", question.toString());
		return questionService.addQuestion(question);
	}
}
