package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;


@Repository
public interface RealEstateMapper {
	public RealEstate selectRealEstate(int id);
	public List<RealEstate> selectRealEstateRentPrice(int rentPrice);
	public List<RealEstate> selectRealEstateAreaPrice(@Param("area")int area, @Param("price")int price);
}
