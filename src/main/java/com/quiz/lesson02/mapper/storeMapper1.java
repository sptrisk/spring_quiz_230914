package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.store1;

@Mapper
public interface storeMapper1 {

	public List<store1> selectStoreList(); 
}
