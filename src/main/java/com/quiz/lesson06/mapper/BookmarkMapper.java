package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {
	public String insertBookmark(
			@Param("name")String name, 
			@Param("url")String url);
	
	public List<Bookmark> selectBookmarkList();
	
	
	// input : url      output: List<>
	public List<Bookmark> selectBookmarkListByUrl(String url);
	
	public int deleteBookmarkById(int id);
	
}
