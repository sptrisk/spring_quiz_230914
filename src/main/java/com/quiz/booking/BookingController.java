package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> bookingList = bookingBO.getbookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// 삭제 - ajax 요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// delete
		int rowCount = bookingBO.deleteBookingById(id);
		
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
	
	// 예약하기 화면
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// 예약하기 - AJAX 요청
		@ResponseBody
		@PostMapping("/make-booking")
		public Map<String, Object> makeBooking(
				@RequestParam("name") String name,
				@RequestParam("date") String date,
				@RequestParam("day") int day,
				@RequestParam("headcount") int headcount,
				@RequestParam("phoneNumber") String phoneNumber) {
			
			// insert db
			bookingBO.addBooking(name, date, day, headcount, phoneNumber);
			
			Map<String, Object> result = new HashMap<>();
			result.put("code", 200);
			result.put("result", "성공");
			return result;
		}
	
	
	

	// 예약 확인 화면
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	
	}
	
	// 예약 확인 - ajax 요청
	@ResponseBody
	@PostMapping("/check-booking")
	public 리턴타입 checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
	}
	
}
