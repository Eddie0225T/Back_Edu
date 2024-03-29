    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Eduardo
 */
@Entity
@Table (name="category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Integer id;
    	private String name;
        private String description;
        
        @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="category")
        @JsonIgnoreProperties("category")
        private List<Motorbike> motorbikes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Motorbike> getMotorbikes() {
        return motorbikes;
    }

    public void setMotorbikes(List<Motorbike> motorbikes) {
        this.motorbikes = motorbikes;
    }

                
}
