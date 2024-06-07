package com.aydenchance.lil.learning_spring.data;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RESERVATION_ID")
	private Long id;
	@Column(name="ROOM_ID")
	private Long RoomId;
	@Column(name="GUEST_ID")
	private Long GuestId;
	@Column(name="RES_DATE")
	private Date reservationDate;
	
	
	public Long getReservationId() {
		return id;
	}
	public void setReservationId(Long id) {
		this.id = id;
	}
	public Long getRoomId() {
		return RoomId;
	}
	public void setRoomId(Long roomId) {
		RoomId = roomId;
	}
	public Long getGuestId() {
		return GuestId;
	}
	public void setGuestId(Long guestId) {
		GuestId = guestId;
	}
	public Date getDate() {
		return reservationDate;
	}
	public void setDate(Date date) {
		this.reservationDate = date;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", RoomId=" + RoomId + ", GuestId=" + GuestId + ", date=" + reservationDate + "]";
	}
	
}
