/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.dao;

import com.eduardo.Reto3.entities.Reservation;
import com.eduardo.Reto3.entities.ReservationCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduardo
 */
@Repository
public class ReservationRepository {
  @Autowired
  private ReservationCrud reservationCrudRepository;
  
  public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
  
  public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
  
  public Reservation save(Reservation reservation) {return reservationCrudRepository.save(reservation);};
  
  public void delete(Reservation reservation){
      reservationCrudRepository.delete(reservation);
  }
}
