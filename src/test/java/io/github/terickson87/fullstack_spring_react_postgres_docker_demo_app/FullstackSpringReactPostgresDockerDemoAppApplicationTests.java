package io.github.terickson87.fullstack_spring_react_postgres_docker_demo_app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class FullstackSpringReactPostgresDockerDemoAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
