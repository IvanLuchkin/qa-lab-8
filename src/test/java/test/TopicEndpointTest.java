package test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.notNullValue;

import config.ApiEndpointTemplateConfig;
import entity.Topic;
import org.junit.Test;

public class TopicEndpointTest {
    private final ApiEndpointTemplateConfig apiTemplate = new ApiEndpointTemplateConfig();

    @Test
    public void testGetAllTopics() {
        apiTemplate.getAllTopics()
                .then()
                .assertThat()
                .body(notNullValue())
                .and()
                .statusCode(200);
    }

    @Test
    public void testUpdateTopic() {
        Topic topic = apiTemplate.getTopicById(1L).as(Topic.class);
        String newDescription = topic.getDescription() + " -- ";
        topic.setDescription(newDescription);

        apiTemplate.updateTopic(topic).then().assertThat().statusCode(200);

        assertEquals(newDescription, apiTemplate.getTopicById(1L).as(Topic.class).getDescription());
    }
}
