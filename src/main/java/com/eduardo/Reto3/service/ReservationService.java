/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.dao.ReservationRepository;
import com.eduardo.Reto3.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationRepository.getAll();};
  
    public Optional<Reservation> getReservation(int id) {return reservationRepository.getReservation(id);};
  
    public Reservation save(Reservation reservation) { 
        if (reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> co =  reservationRepository.getReservation(reservation.getIdReservation());
            if (co.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> re= reservationRepository.getReservation(reservation.getIdReservation());
            if(!re.isEmpty()){
                if(reservation.getStartDate()!=null){
                    re.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    re.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    re.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(re.get());
                return re.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }          
    }  
    
    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
