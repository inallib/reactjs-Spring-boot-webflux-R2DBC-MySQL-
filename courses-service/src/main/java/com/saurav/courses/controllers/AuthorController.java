package com.saurav.courses.controllers;

import com.saurav.courses.dto.Author;
import com.saurav.courses.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    private Flux<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
