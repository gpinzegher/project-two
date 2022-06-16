package br.com.pzg.project.two.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
}
