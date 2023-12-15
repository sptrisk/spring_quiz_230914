package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.storeBO;
import com.quiz.lesson02.domain.store;

@RestController
public class Lesson02Quiz01RestController {
	@Autowired
	private storeBO storebo;
	// url : http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<store> quiz01(){
		return storebo.getStoreList();
	}
}
