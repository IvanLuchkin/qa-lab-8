package cucumber;

import config.ApiEndpointTemplateConfig;
import entity.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static config.ApiPathConfig.BASE_URL;
import static org.hamcrest.CoreMatchers.equalTo;

public class Steps {

    private Response response;
    private long id;
    private Page page;
    private final ApiEndpointTemplateConfig endpointTemplate = new ApiEndpointTemplateConfig();

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Given("page id is {long}")
    public void givenPageId(long id) {
        this.id = id;
    }

    @Given("page with next data:")
    public void givenPage(DataTable dataTable) {
        page = convertDataTableToListOfPages(dataTable).get(0);
    }

    @When("I try to get page by id")
    public void getPageById() {
        response = endpointTemplate.getPageById(id);
    }

    @When("I try to create new page")
    public void createNewPage() {
        response = endpointTemplate.createPage(page);
    }

    @When("I try to modify page")
    public void modifyPage() {
        response = endpointTemplate.updatePage(page);
    }

    @When("I try to delete page")
    public void deletePage() {
        response = endpointTemplate.deletePageById(id);
    }

    @Then("I receive status code {int}")
    public void compareStatusCodes(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("I receive page with id {int}")
    public void checkThatIdsIsEqual(int id) {
        response.then().body("id", equalTo(Integer.valueOf(id).toString()));
    }

    private List<Page> convertDataTableToListOfPages(DataTable table) {
        return table.asMaps(Object.class, Object.class).stream()
                .map(this::mapToPage)
                .collect(Collectors.toList());
    }

    private Page mapToPage(Map<Object, Object> map) {
        if (map.containsKey("id")) {
            return new Page(Long.parseLong((String) map.get("id")),
                    ZonedDateTime.parse((String) map.get("createdAt")),
                    (String) map.get("name"), (String) map.get("pageUrl"));
        } else {
            return new Page(ZonedDateTime.parse((String) map.get("createdAt")),
                    (String) map.get("name"), (String) map.get("pageUrl"));
        }
    }
    
}