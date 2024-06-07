package com.aydenchance.lil.learning_spring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.aydenchance.lil.learning_spring.data.Room;
import com.aydenchance.lil.learning_spring.data.RoomRepository;
import com.aydenchance.lil.learning_spring.data.Guest;
import com.aydenchance.lil.learning_spring.data.GuestRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	
	public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
		Iterable<Guest> guests = this.guestRepository.findAll();
		guests.forEach(System.out::println);
		
	}

}
