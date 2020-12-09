package com.saurav.courses.controllers;

import com.saurav.courses.dto.Course;
import com.saurav.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    private Mono<Course> saveCourse(@RequestBody @Valid Course course) {
        return courseRepository.save(course);
    }

    @GetMapping
    private Flux<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @DeleteMapping
    private Mono<Void> deleteCourse(@RequestBody Course course) {
        return courseRepository.deleteById(course.getId());
    }

    @ExceptionHandler
    public ResponseEntity handleException(Exception e) {
        if (e instanceof MethodArgumentNotValidException)
            return new ResponseEntity("Invalid arguments", HttpStatus.BAD_REQUEST);
        return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
