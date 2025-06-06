package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models;

import java.util.List;

public record AllNotesResponsePage(List<NoteResponse> notes, PageInfo<Integer, Long> pageInfo) {}
