package com.telusko.service;

import com.telusko.dao.QuestionDao;
import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Service
public class QuestionService {

	private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestions(List<Question> questions) {
		questionDao.saveAll(questions);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("Error: ", e);
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> add(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions = questionDao.findRandomQuesitonsByCategory(categoryName, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

		for(Integer id : questionsIds) {
			questions.add(questionDao.findById(id).orElse(null));
		}

		for(Question question : questions) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
		}

		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int right = 0;
		for(Response response : responses) {
			Question question = questionDao.findById(response.getId()).get();
			if(response.getResponse().equals(question.getRightAnswer()))
				right++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}
}
