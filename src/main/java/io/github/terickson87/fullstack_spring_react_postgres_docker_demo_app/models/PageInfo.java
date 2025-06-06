package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app.models;

public record PageInfo<T,C>(T pageSize, C continuation) {
    // A no-argument constructor to mimic Kotlin's default values.
    public PageInfo() {
        this(null, null);
    }

}
