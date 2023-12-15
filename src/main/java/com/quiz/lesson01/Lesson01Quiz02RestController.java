package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {
	
	// url : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String,Object>> quiz02_01() {
		List<Map<String,Object>> list = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
			movie.put("rate", 15);
			movie.put("director", "봉준호");
			movie.put("time", 131);
			movie.put("title", "기생충");
		
			list.add(movie);
			
		movie = new HashMap<String,Object>();
		movie.put("rate", 0);
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("title", "인생은 아름다워");
				list.add(movie);
				
		movie = new HashMap<String,Object>();
		movie.put("rate", 12);
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("title", "인셉션");
				list.add(movie);
				
		movie = new HashMap<String,Object>();
		movie.put("rate", 19);
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
				list.add(movie);
				
		movie = new HashMap<String,Object>();
		movie.put("rate", 15);
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("title", "헝거게임");
				list.add(movie);
				return list;
	}
	
	// url : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Board> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter	=> String -> HTML 변환
		// @ResponseBody + return 객체(Map, Class, List...) => HttpMessageConverter	 jackson 라이브러리 => JSON 응답 
		List<Board> list = new ArrayList<>();
		
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		list.add(board);
		
		board = new Board();
		board.setTitle("헐 대박");
		board.setUser("bada");
		board.setContent("오늘 목요일이었어... 금요일인 줄");
		list.add(board);
		
		board = new Board();
		board.setTitle("오늘 데이트 한 이야기 해드릴게요");
		board.setUser("dulumary");
		board.setContent("...");
		list.add(board);

		return list;
	}
	
	// url : http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Board> quiz02_3() {
		Board board = new Board();
		board.setTitle("안녕하세요. 가입인사 드립니다.");
		board.setUser("marobiana");
		board.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");

		return new ResponseEntity<>(board, HttpStatus.GATEWAY_TIMEOUT);
	}
	
	
}
				
				
	

