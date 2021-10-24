/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.entities.Category;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins= "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> getCategories() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int idCat) {
        return categoryService.getCategory(idCat);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId){
        return categoryService.deleteCategory(categoryId);
    }
}
