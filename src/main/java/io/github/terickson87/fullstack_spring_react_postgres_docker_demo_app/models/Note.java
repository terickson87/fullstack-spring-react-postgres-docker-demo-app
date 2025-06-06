package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models;

import java.time.Instant;

public record Note(Long id, Instant createdAt, Instant updatedAt, String body) {}
