package com.example.AutoComplete.controller;

import com.example.AutoComplete.service.AutoCompleteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autocomplete")
public class AutoCompleteController {
    private final AutoCompleteService service;

    public AutoCompleteController(AutoCompleteService service) {
        this.service = service;
    }

    @PostMapping("/terms")
    public String addTerm(
            @RequestParam String term) {

        service.addTerm(term);

        return "Term added";
    }

    @PostMapping("/search")
    public String recordSearch(
            @RequestParam String term) {

        return "Search recorded";
    }
}
