package com.saurav.courses.repositories;

import com.saurav.courses.dto.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AuthorRepository extends ReactiveCrudRepository<Author, Integer> {}
