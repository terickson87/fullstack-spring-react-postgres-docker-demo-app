package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models.Note;

public interface NoteRepository extends ListCrudRepository<Note, Long>, PagingAndSortingRepository<Note, Long> {
    
}
