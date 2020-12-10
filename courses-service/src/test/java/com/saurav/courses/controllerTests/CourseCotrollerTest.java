package com.saurav.courses.controllerTests;

import com.saurav.courses.controllers.CourseController;
import com.saurav.courses.dto.Course;
import com.saurav.courses.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CourseController.class)
public class CourseCotrollerTest {
    @MockBean
    CourseRepository courseRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    void saveCourseTest(){
        Course course = new Course();
        course.setAuthorId(1);
        course.setCategory("category1");
        course.setTitle("title1");

        Mockito.when(courseRepository.save(course)).thenReturn(Mono.just(course));

        webClient.post()
                .uri("/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(course))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(courseRepository, times(1)).save(course);
    }

    @Test
    void deleteCourseTest(){
        Mono<Void> voidReturn  = Mono.empty();
        Mockito
                .when(courseRepository.deleteById(1))
                .thenReturn(voidReturn);

        webClient.delete().uri("/courses/{id}", 1)
                .exchange()
                .expectStatus().isOk();
        Mockito.verify(courseRepository, times(1)).deleteById(1);
    }
}
