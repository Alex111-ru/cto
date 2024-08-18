package com.example.kinopoisk.controller;

import com.example.kinopoisk.model.Critic;
import com.example.kinopoisk.service.CriticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/critics")
public class CriticController {

    @Autowired
    private CriticService criticService;

    @GetMapping
    public ResponseEntity<List<Critic>> getAllCritics() {
        List<Critic> critics = criticService.getAllCritics();
        return ResponseEntity.ok(critics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Critic> getCriticById(@PathVariable Long id) {
        Optional<Critic> critic = criticService.getCriticById(id);
        return critic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Critic> createCritic(@RequestBody Critic critic) {
        Critic createdCritic = criticService.createCritic(critic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCritic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Critic> updateCritic(@PathVariable Long id, @RequestBody Critic critic) {
        try {
            Critic updatedCritic = criticService.updateCritic(id, critic);
            return ResponseEntity.ok(updatedCritic);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCritic(@PathVariable Long id) {
        try {
            criticService.deleteCritic(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}