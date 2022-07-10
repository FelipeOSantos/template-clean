package br.dev.fos.clean.templateclean.infrastructure;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@DirtiesContext
public abstract class MongoDbContainerBaseTest {
  
    @Container
    private static final MongoDBContainer MONGO_DB_CONTAINER  = new MongoDBContainer(DockerImageName.parse("mongo:5.0.9"));

    static {
        MONGO_DB_CONTAINER.start();
    }

    public static MongoDBContainer getMongoDBContainerInstance(){
        return MONGO_DB_CONTAINER;
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.host", MONGO_DB_CONTAINER::getHost);
        registry.add("spring.data.mongodb.port", () -> MONGO_DB_CONTAINER.getMappedPort(27017));
        registry.add("spring.data.mongodb.database", () -> "test");
        registry.add("spring.data.mongodb.option.max-connection-idle-time", () -> "60000");
    }
}
