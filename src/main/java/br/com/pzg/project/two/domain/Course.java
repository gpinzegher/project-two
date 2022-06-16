package br.com.pzg.project.two.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Course {
    private UUID id;
    private String name;
    private Author author;
}
