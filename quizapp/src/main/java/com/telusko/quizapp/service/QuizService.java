package com.telusko.quizapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.telusko.quizapp.model.QuestionWrapper;
import com.telusko.quizapp.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quizapp.dao.QuestionDao;
import com.telusko.quizapp.dao.QuizDao;
import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.model.Quiz;

@Service
public class QuizService {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizService.class);

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuesitonsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.orElseThrow().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}

		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).orElseThrow();
		List<Question> questions = quiz.getQuestions().stream().sorted(Comparator.comparing(Question::getId)).toList();
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
