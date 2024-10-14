package com.example.demo.controller;

import com.example.demo.model.Superhero;
import com.example.demo.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

    @Autowired
    private SuperheroService service;

    @PostMapping
    public ResponseEntity<String> createHero(@RequestBody Superhero hero) {
        service.addHero(hero);
        return new ResponseEntity<>("Superhero created!", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Superhero> getAllHeroes() {
        return service.getAllHeroes();
    }
}
