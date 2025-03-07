package com.library.libraryapi.dto;

import com.library.libraryapi.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherFillDTO {

    private String cnpj;
    private String name;
    private AddressModel address;
}
