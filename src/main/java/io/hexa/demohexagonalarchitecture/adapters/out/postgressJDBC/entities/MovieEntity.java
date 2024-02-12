package io.hexa.demohexagonalarchitecture.adapters.out.postgressJDBC.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "movies")
public record MovieEntity(
        @Id
        Long id,
        String title,
        String description,
        @Column("releaseDate")
        LocalDate releaseDate,

        @Column("directorName")
        String directorName,
        @Version
        Integer version
) {
}
