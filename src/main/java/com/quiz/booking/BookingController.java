package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/lesson06/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/bookingList")
	public List<Booking> bookingListView() {
		
		return "booking/bookingList";
	}
}
