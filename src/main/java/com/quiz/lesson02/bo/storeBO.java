package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.store;
import com.quiz.lesson02.mapper.storeMapper;

@Service
public class storeBO {
	@Autowired 
	private storeMapper storemapper;
	
	public List<store> getStoreList() {
		return storemapper.selectStoreList();
	}
}
