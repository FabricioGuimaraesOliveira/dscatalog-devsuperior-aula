package com.devsuperior.dscatolog.entities;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor

public class Category implements Serializable {

    private static final long serialVersionUID=1L;
    private Long id;
    private String name;


}
