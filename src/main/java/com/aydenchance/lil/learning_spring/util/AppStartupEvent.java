package com.aydenchance.lil.learning_spring.util;

import java.sql.Date;
import java.util.List;

import org.h2.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.aydenchance.lil.learning_spring.data.Room;
import com.aydenchance.lil.learning_spring.data.RoomRepository;
import com.aydenchance.lil.learning_spring.business.ReservationService;
import com.aydenchance.lil.learning_spring.business.RoomReservation;
import com.aydenchance.lil.learning_spring.data.Guest;
import com.aydenchance.lil.learning_spring.data.GuestRepository;
import com.aydenchance.lil.learning_spring.data.Reservation;
import com.aydenchance.lil.learning_spring.data.ReservationRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	private final ReservationService reservationService;
	
	public AppStartupEvent(RoomRepository roomRepository,
			GuestRepository guestRepository,
			ReservationRepository reservationRepository,
			ReservationService reservationService) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
		this.reservationService = reservationService;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
//		Iterable<Room> rooms = this.roomRepository.findAll();
//		rooms.forEach(System.out::println);
//		Iterable<Guest> guests = this.guestRepository.findAll();
//		guests.forEach(System.out::println);
//		Iterable<Reservation> reservations = this.reservationRepository.findAll();
//		reservations.forEach(System.out::println);
		
		Date date = new Date(DateTimeUtils.parseDateValue("20220101", 0, 8));
		List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
		reservations.forEach(System.out::println);
		
		
	}

}
