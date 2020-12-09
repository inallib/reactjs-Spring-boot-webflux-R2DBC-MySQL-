package com.saurav.courses.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Course {

    @Id
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String category;

    @NotNull
    private int authorId;
}
