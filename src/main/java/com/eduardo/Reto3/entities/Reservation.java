/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Eduardo
 */
@Entity
@Table (name="reservation")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer idReservation;
    	private Date startDate;
        private Date devolutionDate;
        private String status = "created";
        
        @ManyToOne
        @JoinColumn(name="idMoto")
        @JsonIgnoreProperties(value ={"reservations", "client"})
        private Motorbike motorbike;
        
        @ManyToOne
        @JoinColumn(name="idClient")
        @JsonIgnoreProperties({"reservations", "messages"})
        private Client client;
        
        private Integer score;
        

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
