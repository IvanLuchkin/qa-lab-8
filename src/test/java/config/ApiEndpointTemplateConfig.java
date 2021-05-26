package config;

import entity.Page;
import entity.Topic;
import entity.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiEndpointTemplateConfig {
    public Response getAllUsers() {
        return given()
                .when()
                .get(ApiPathConfig.USERS_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response getUserById(Long id) {
        return given()
                .pathParam("userId", id)
                .when()
                .get(ApiPathConfig.USER_BY_ID)
                .then()
                .extract().response();
    }

    public Response createUser(User user) {
        return given()
                .body(user)
                .when()
                .post(ApiPathConfig.USERS_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response createPage(Page page) {
        return given()
                .body(page)
                .when()
                .post(ApiPathConfig.PAGES_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response getAllUserContacts(Long userId) {
        return given()
                .pathParam("userId", userId)
                .when()
                .get(ApiPathConfig.CONTACTS_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response getAllPages() {
        return given()
                .when()
                .get(ApiPathConfig.PAGES_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response getPageById(Long id){
        return given()
                .pathParam("pageId", id)
                .when()
                .get(ApiPathConfig.PAGE_BY_ID)
                .then()
                .extract().response();
    }

    public Response deletePageById(Long id) {
        return given()
                .pathParam("pageId", id)
                .when()
                .delete(ApiPathConfig.PAGE_BY_ID)
                .then()
                .extract().response();
    }

    public Response getAllTopics() {
        return given()
                .when()
                .get(ApiPathConfig.TOPICS_ENDPOINT)
                .then()
                .extract().response();
    }

    public Response getTopicById(Long id){
        return given()
                .pathParam("topicId", id)
                .when()
                .get(ApiPathConfig.TOPIC_BY_ID)
                .then()
                .extract().response();
    }

    public Response updateTopic(Topic topic) {
        return given()
                .pathParam("topicId", topic.getId())
                .body(topic)
                .when()
                .put(ApiPathConfig.TOPIC_BY_ID)
                .then()
                .extract().response();
    }

    public Response updatePage(Page page) {
        return given()
                .pathParam("pageId", page.getId())
                .body(page)
                .when()
                .put(ApiPathConfig.PAGE_BY_ID)
                .then()
                .extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(ApiPathConfig.BASE_URL)
                .contentType(ContentType.JSON);
    }
}
