/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.dao.CategoryRepository;
import com.eduardo.Reto3.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.getAll();};
  
    public Optional<Category> getCategory(int CategoryId) {
        return categoryRepository.getCategory(CategoryId);};
  
     public Category save(Category category) { 
        if (category.getId()== null){
           return categoryRepository.save(category);
        }else{
            Optional<Category> ca =  categoryRepository.getCategory(category.getId());
            if (ca.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
  
    public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category> ca= categoryRepository.getCategory(category.getId());
            if(!ca.isEmpty()){
                if(category.getName()!=null){
                    ca.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    ca.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(ca.get()); 
            }
        }
            return category;   
    }   
    
    public boolean deleteCategory(int categoryId){
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
