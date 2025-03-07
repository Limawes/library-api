package com.library.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookFillDto {

    private String name;
    private String topic;
    private Long tipping;
    private Boolean status;
    private String authorName;
    private String publisherName;
}
