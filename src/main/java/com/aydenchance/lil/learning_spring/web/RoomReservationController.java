package com.aydenchance.lil.learning_spring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aydenchance.lil.learning_spring.business.ReservationService;
import com.aydenchance.lil.learning_spring.business.RoomReservation;
import com.aydenchance.lil.learning_spring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
	
	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	
	public RoomReservationController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value="date", required=false) String dateString, Model model) {
		Date date = dateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "roomres";
	}
}
