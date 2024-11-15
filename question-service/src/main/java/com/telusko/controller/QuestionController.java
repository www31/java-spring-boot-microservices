package com.telusko.controller;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;
import com.telusko.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	QuestionService questionService;

	@Autowired
	Environment environment;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}") 
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("addQuestions")
	public ResponseEntity<String> addQuestions(@RequestBody List<Question> questions) {
		int i = 0;
		for (Question question : questions) {
			i++;
            LOGGER.info("{} {} - {}", this.getClass().getCanonicalName(), i, question.toString());
		}
		return questionService.addQuestions(questions);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        LOGGER.info("{} - {}", this.getClass().getCanonicalName(), question.toString());
		return questionService.addQuestion(question);
	}

	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions) {
		return questionService.getQuestionsForQuiz(categoryName, numQuestions);
	}

	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsIds) {
		LOGGER.info("{}", environment.getProperty("local.server.port"));
		return questionService.getQuestionsFromId(questionsIds);
	}

	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
		LOGGER.info("getScore - {}",responses);
		return questionService.getScore(responses);
	}
}
