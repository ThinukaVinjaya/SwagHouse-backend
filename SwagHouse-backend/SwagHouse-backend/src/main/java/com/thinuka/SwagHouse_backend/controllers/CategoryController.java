package com.thinuka.SwagHouse_backend.controllers;


import com.thinuka.SwagHouse_backend.dto.CategoryDto;
import com.thinuka.SwagHouse_backend.entities.Category;
import com.thinuka.SwagHouse_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id", required = true) Long categoryId){
          Category category = categoryService.getCategory(categoryId);
          return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.creatCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
