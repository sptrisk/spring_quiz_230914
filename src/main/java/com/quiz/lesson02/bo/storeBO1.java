package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.store1;
import com.quiz.lesson02.mapper.storeMapper1;

@Service
public class storeBO1 {
	
	@Autowired 
	private storeMapper1 storeMapper;
	
	public List<store1> getStoreList() {
		return storeMapper.selectStoreList();
	}
}
