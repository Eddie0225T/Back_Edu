/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.entities.Motorbike;
import com.eduardo.Reto3.dao.MotorbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Eduardo
 */
@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll() {
        return (List<Motorbike>) motorbikeRepository.getAll();};
  
    public Optional<Motorbike> getMotorbike(int id) {
        return motorbikeRepository.getMotorbike(id);};
  
    public Motorbike save(Motorbike motorbike) { 
        if (motorbike.getId()== null){
            return motorbikeRepository.save(motorbike);
        }else{
            Optional<Motorbike> mo =  motorbikeRepository.getMotorbike(motorbike.getId());
            if (mo.isEmpty()){
                return motorbikeRepository.save(motorbike);
            }else{
                return motorbike;
            }
        }
    }
  
    public Motorbike update (Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> mo= motorbikeRepository.getMotorbike(motorbike.getId());
            if(!mo.isEmpty()){
                if(motorbike.getName()!=null){
                    mo.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    mo.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    mo.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    mo.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    mo.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(mo.get());
                return mo.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }   
    
    public boolean deleteMotorbike(int motoId){
        Boolean aBoolean = getMotorbike(motoId).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }   
}