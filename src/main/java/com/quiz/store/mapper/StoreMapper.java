package com.quiz.store.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.store.domain.Store;

@Repository
public interface StoreMapper {

	public List<Store> selectStoreList(); 
}
