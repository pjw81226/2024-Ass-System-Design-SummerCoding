package org.landvibe.ass1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/ass_system_test?serverTimezone=UTC&characterEncoding=UTF-8",
        "SPRING_DATASOURCE_USERNAME=ass_system_user",
        "SPRING_DATASOURCE_PASSWORD=password",
        "SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver",
        "SPRING_REDIS_HOST=localhost",
        "SPRING_REDIS_PORT=6379",
        "SERVER_NAME=test_server"
})
public class Ass1ApplicationTests {
    @Test
    public void contextLoads() {
    }
}
