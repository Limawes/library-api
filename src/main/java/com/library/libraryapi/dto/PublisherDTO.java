package com.library.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    private String cnpj;
    private String name;
    private AddressDTO address;
}
