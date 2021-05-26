package test;

import static org.hamcrest.Matchers.notNullValue;

import config.ApiEndpointTemplateConfig;
import entity.User;
import java.time.ZonedDateTime;
import org.junit.Test;

public class UserEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllUsers() {
        apiTemplate.getAllUsers()
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testGetUserByValidId() {
        apiTemplate.getUserById(1L)
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testGetUserByInvalidId() {
        apiTemplate.getUserById(1000L)
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void testCreateUser() {
        User user = new User(100L, ZonedDateTime.now(), "Test User", "none");
        apiTemplate.createUser(user)
                .then().assertThat()
                .body(notNullValue())
                .and()
                .statusCode(201);
    }
}
