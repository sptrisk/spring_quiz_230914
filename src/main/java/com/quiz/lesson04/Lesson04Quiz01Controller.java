package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
		// url : http://localhost:8080/lesson04/quiz01/add-seller-view
	
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// DB insert => 입력 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname")String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 화면
	// http://localhost:8080/lesson04/quiz01/seller_info-view?id=1
	@GetMapping("/seller_info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
			
		
		// db select
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		
				
		// model
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 응답 화면
		return "lesson04/sellerInfo";
	}

}
