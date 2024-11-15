package com.telusko.service;

import com.telusko.dao.QuizDao;
import com.telusko.feign.QuizInterface;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizService.class);

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).orElseThrow();
		List<Integer> questionIds = quiz.getQuestionIds();
		LOGGER.info("questionIds - {}",questionIds);
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		return score;
	}
}
