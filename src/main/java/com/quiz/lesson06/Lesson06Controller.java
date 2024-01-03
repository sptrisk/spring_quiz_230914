package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Controller {
	@Autowired
	private BookmarkBO bookmarkBO;

	@GetMapping("/add-bookmark")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name")String name,
			@RequestParam("url")String url) {
		
		//DB INSERT
		bookmarkBO.addBookmark(name, url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200); // OK
		result.put("result", "성공");
		
		return result; // map => JSON String
	}
	
	
	
	
	// 성공 화면 & 즐겨찾기 목록
	@GetMapping("/after-add-bookmark")
	public String afterAddBookmark(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/afterAddBookmark";
	}
	
	// url중복확인 - AJAX요청
	@ResponseBody
	@PostMapping("/is-duplicated-url")
	public Map<String, Object> isDuplicatedUrl(
			@RequestParam("url") String url) {
		
		// db select
		boolean isDuplicated = bookmarkBO.isDuplicatedUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplicated", isDuplicated);
		
		return result;
		
	}
	
	// 즐겨찾기 삭제 - AJAX 요청
	@ResponseBody
	@PostMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id) {
		
		// db delete
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제하는데 실패했습니다.");
		}
		
		return result;
	}
	
	
}
