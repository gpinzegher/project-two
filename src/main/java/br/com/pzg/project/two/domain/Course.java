package br.com.pzg.project.two.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class Course {
    private UUID id;
    private String catalogTitle;
    private String description;
    @JsonManagedReference()
    private Author author;
}
