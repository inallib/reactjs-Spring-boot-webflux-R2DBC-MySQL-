package com.saurav.courses.repositories;

import com.saurav.courses.dto.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourseRepository extends ReactiveCrudRepository<Course, Integer> {}
