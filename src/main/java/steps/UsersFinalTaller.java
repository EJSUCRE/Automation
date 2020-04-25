package steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pojo.UserPojoFinalTaller;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class UsersFinalTaller {

    private String endpoint;
    private Response response;
    public Logger log = Logger.getLogger(UsersFinalTaller.class);

    /**
     * Constructor.
     * @param uri String
     */
    public UsersFinalTaller(String uri) {
        endpoint = uri + "/v1/students/";
    }

    /**
     * Get users endpoint print.
     */
    @Step("Given the users API endpoint")
    public void getUsersAPIEndpoint() {
        log.info(endpoint);
    }

    /**
     * GET Method users/:id.
     * @param id String
     */
    @Step("When I look for the user with id {0}")
    public void getUser(String id) {
        response = given()
                .contentType(ContentType.JSON)
            .when()
                .get(endpoint + id);
        log.info(response.asString());
    }

    /**
     * GET Method users (list of users).
     */
    @Step("When I look for users")
    public void getUsers() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get(endpoint);
    }

    /**
     * POST Method create new user.
     * @param users list of {@link UsersFinalTaller}
     */
    @Step("When I create users")
    public void createUsers(List<UsersFinalTaller> users) {
        for (UsersFinalTaller user : users) {
            response = given()
                    .contentType(ContentType.JSON)
                    .body(user)
                .when()
                    .post(endpoint);

            Assert.assertEquals(201, response.statusCode());
        }
    }

    /**
     * PUT Method update Final_note of a user.
     * @param id String
     * @param finalNote String
     */
    @Step("When I update the finalNote of the user with id {0} with {1}")
    public void updateUserFinalNote(String id, String finalNote) {

        UserPojoFinalTaller user = new UserPojoFinalTaller();
        user.setFinal_note(finalNote);

        given()
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .put(endpoint + id);
    }

    /**
     * PUT Method update approved of a user.
     * @param id String
     * @param approved String
     */
    @Step("When I update the approved status of the user with id {0} with {1}")
    public void updateUserApproved(String id, boolean approved) {

        UserPojoFinalTaller user = new UserPojoFinalTaller();
        user.setApproved(approved);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(endpoint + id);
    }

    /**
     * DELETE Method, delete user by id.
     * @param id String
     */
    @Step("When I delete the user with id {0}")
    public void deleteUser(String id) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint + id);
    }

    /**
     * Verify expected title.
     * @param finalNote String
     */
    @Step("Then the job title will be equals to {0}")
    public void finalNoteChanged(String finalNote) {
        then()
                .body("final_note", equalTo(finalNote));
    }

    /**
     * Verify expected title.
     * @param approved Boolean
     */
    @Step("Then the job title will be equals to {0}")
    public void approvedChanged(boolean approved) {
        then()
                .body("approved", equalTo(approved));
    }

    /**
     * Verify expected status code.
     * @param statusCode int
     */
    @Step("Then the status code will be {0}")
    public void isStatusCode(int statusCode) {
        then()
                .statusCode(statusCode);
    }

    /**
     * Print list of users.
     */
    @Step("Then I can see the list of users")
    public void showActualUsersList() {
        List<UsersFinalTaller> users = then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .jsonPath()
                .getList("$", UsersFinalTaller.class);

        log.info(users);
    }

    /**
     * Verify expected email.
     * @param email String
     */
    @Step("Then there should be a email filed with value {0}")
    public void userEmailShouldBe(String email) {
        response.then().body("email", equalTo(email));
    }
}
