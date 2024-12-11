package ed_wantuil.java_docker_sample;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.nio.file.Paths;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    private static final String PROJECT_ROOT = Paths.get("").toAbsolutePath().toString();
    private static final String INIT_SCRIPTS_PATH = Paths.get(PROJECT_ROOT, "docker", "postgres-init").toString();

    private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:14")
            .withDatabaseName("testdb")
            .withUsername("user")
            .withPassword("password")
            .withFileSystemBind(INIT_SCRIPTS_PATH, "/docker-entrypoint-initdb.d", BindMode.READ_ONLY);

    static {
        POSTGRE_SQL_CONTAINER.start();
    }

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @DynamicPropertySource
    static void configureProperties(org.springframework.test.context.DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRE_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRE_SQL_CONTAINER::getPassword);
    }
}
