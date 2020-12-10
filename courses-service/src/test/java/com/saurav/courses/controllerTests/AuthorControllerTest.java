package com.saurav.courses.controllerTests;

import com.saurav.courses.controllers.AuthorController;
import com.saurav.courses.dto.Author;
import com.saurav.courses.repositories.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AuthorController.class)
public class AuthorControllerTest {
    @MockBean
    AuthorRepository authorRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    void getAllAuthorTest(){
        Author author1 = new Author();
        author1.setId(1);
        author1.setName("Author1");

        Author author2 = new Author();
        author2.setId(2);
        author2.setName("Author2");

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        Flux<Author> authorFlux = Flux.fromIterable(authors);

        Mockito
                .when(authorRepository.findAll())
                .thenReturn(authorFlux);


        webClient.get().uri("/authors")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Author.class);

        Mockito.verify(authorRepository, times(1)).findAll();
    }
}
