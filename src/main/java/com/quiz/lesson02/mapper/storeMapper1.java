package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.store1;

@Repository
public interface storeMapper1 {

	public List<store1> selectStoreList(); 
}
