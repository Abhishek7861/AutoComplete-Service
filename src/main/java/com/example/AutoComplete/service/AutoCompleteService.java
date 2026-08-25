package com.example.AutoComplete.service;

import com.example.AutoComplete.repository.AutoCompleteRepository;
import org.springframework.stereotype.Service;

@Service
public class AutoCompleteService {
    private final AutoCompleteRepository repository;

    public AutoCompleteService(AutoCompleteRepository repository) {
        this.repository = repository;
    }
    public void addTerm(String term) {

        repository.addTerm(term, 1);
    }

}
