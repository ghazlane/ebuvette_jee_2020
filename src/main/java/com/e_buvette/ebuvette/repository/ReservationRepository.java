package com.e_buvette.ebuvette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	public List<Reservation> findByClientId(int id);
}
