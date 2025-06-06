package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

public record DbNote(@Id Long id, Timestamp createdAt, Timestamp updatedAt, String body) {}
