package com.example.demo.controller;

import com.example.demo.model.Superhero;
import com.example.demo.service.SuperheroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<String> createHero(@RequestBody String rawHeroData) {
        String validJson = rawHeroData.replace("'", "\"");

        ObjectMapper objectMapper = new ObjectMapper();
        Superhero hero = null;
        try {
            hero = objectMapper.readValue(validJson, Superhero.class);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>("Wrong JSON format", HttpStatus.BAD_REQUEST);
        }

        service.addHero(hero);
        return new ResponseEntity<>("Superhero created!", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Superhero> getAllHeroes() {
        return service.getAllHeroes();
    }
}
