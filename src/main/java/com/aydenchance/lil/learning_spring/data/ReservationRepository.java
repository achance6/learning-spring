package com.aydenchance.lil.learning_spring.data;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
	Iterable<Reservation> findReservationByReservationDate(Date date);
}
