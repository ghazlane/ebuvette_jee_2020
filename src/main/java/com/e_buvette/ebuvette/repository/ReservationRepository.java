package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
