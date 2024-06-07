package com.aydenchance.lil.learning_spring.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.aydenchance.lil.learning_spring.data.Room;
import com.aydenchance.lil.learning_spring.data.RoomRepository;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

	private final RoomRepository roomRepository;
	
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
		
	}

}
