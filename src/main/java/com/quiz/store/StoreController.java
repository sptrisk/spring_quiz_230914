package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.store.bo.StoreBO;
import com.quiz.store.domain.Store;


@RequestMapping("/Store")
@Controller
public class StoreController {
	@Autowired StoreBO storeBO;
	
	@GetMapping("/StoreList-View")
	public String StoreListView(Model model) {
		List<Store> StoreList = storeBO.getStoreList();
		model.addAttribute("StoreList", StoreList);
		return "store/storeList";
	}
}
