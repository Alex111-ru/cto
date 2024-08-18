package com.example.kinopoisk.service;

import com.example.kinopoisk.model.Critic;
import com.example.kinopoisk.repository.CriticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriticService {
    @Autowired
    private CriticRepository criticRepository;

    public List<Critic> getAllCritics() {
        return criticRepository.findAll();
    }

    public Optional<Critic> getCriticById(Long id) {
        return criticRepository.findById(id);
    }

    public Critic createCritic(Critic critic) {
        return criticRepository.save(critic);
    }

    public Critic updateCritic(Long id, Critic critic) {
        critic.setId(id);
        return criticRepository.save(critic);
    }

    public void deleteCritic(Long id) {
        criticRepository.deleteById(id);
    }
}
