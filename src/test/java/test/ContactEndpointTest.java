package test;

import static org.hamcrest.Matchers.notNullValue;

import config.ApiEndpointTemplateConfig;
import org.junit.Test;

public class ContactEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllUserContacts() {
        apiTemplate.getAllUserContacts(1L)
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }
}
