 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins= "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class MotorbikeController {
    @Autowired
    private MotorbikeService motorbikeService;
    @GetMapping("/all")
    public List<Motorbike> getMotorbikes(){
        return motorbikeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbike(@PathVariable("id") int id) {
        return motorbikeService.getMotorbike(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike) {
        return motorbikeService.save(motorbike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike){
        return motorbikeService.update(motorbike);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int motoId){
        return motorbikeService.deleteMotorbike(motoId);
    }
}