package test;

import static org.hamcrest.Matchers.notNullValue;

import config.ApiEndpointTemplateConfig;
import org.junit.Test;

public class PageEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllPages() {
        apiTemplate.getAllPages()
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testGetPageByValidId() {
        apiTemplate.getPageById(1L)
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testGetPageByInvalidId() {
        apiTemplate.getPageById(1000L)
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void testDeletePageById() {
        apiTemplate.deletePageById(4L)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
