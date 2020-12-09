package com.saurav.courses.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Author {
    @Id
    private int id;
    private String name;
}
