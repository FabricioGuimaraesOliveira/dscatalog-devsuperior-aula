package com.devsuperior.dscatolog.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;

    @Getter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createAt;

    @Getter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updateAt;

    @PrePersist
    public void prePersist() {
        createAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = Instant.now();
    }

}
