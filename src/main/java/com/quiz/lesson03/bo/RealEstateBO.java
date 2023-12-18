package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

		@Autowired
		private RealEstateMapper realestatemapper;
		
		public RealEstate getRealEstate(int id) {
			return realestatemapper.selectRealEstate(id);
		}

		public List<RealEstate> getRealEstateRentPrice(int rentPrice) {
			return realestatemapper.selectRealEstateRentPrice(rentPrice);
		}
		
		public List<RealEstate> getRealEstateAreaPrice(int area, int price){
			return realestatemapper.selectRealEstateAreaPrice(area, price);
		}
}
