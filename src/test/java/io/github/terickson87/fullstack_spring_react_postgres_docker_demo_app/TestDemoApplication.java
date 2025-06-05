package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app;

import org.springframework.boot.SpringApplication;

public class TestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.from(FullstackSpringReactPostgresDockerDemoAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
