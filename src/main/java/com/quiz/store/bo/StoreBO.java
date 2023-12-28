package com.quiz.store.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.store.domain.Store;
import com.quiz.store.mapper.StoreMapper;

@Service
public class StoreBO {
	@Autowired 
	private StoreMapper storeMapper;
	
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
}
