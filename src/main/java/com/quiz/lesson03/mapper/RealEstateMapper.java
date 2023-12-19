package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;


@Repository
public interface RealEstateMapper {
	public RealEstate selectRealEstate(int id);
	public List<RealEstate> selectRealEstateRentPrice(int rentPrice);
	public List<RealEstate> selectRealEstateAreaPrice(
			// MyBatis 문법 상 parameter는 단 한개만 xml로 보낼 수 있다.
			// 따라서 여러개의 파라미터를 보낼 경우 하나의 map에 담아서 보낸다.
			// 맵으로 만들어주는 annotation @Param
			@Param("area")int area, @Param("price")int price);
	
	
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(@Param("id")int id,@Param("type")String type, @Param("price")int price);

}
