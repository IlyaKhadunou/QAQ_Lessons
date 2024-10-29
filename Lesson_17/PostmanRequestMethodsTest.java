package Lesson_17;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PostmanRequestMethodsTest {

    private final String BASE_URL = "https://postman-echo.com";

    @Test
    @DisplayName("Тест метода Get")
    public void testGet() {
        try {
            Response response = RestAssured.given()
                    .when()
                    .get(BASE_URL + "/get?foo1=bar1&foo2=bar2")
                    .then()
                    .statusCode(200)
                    .extract().response();

            assertEquals(200, response.getStatusCode());

            assertEquals("bar1", response.jsonPath().getString("args.foo1"));
            assertEquals("bar2", response.jsonPath().getString("args.foo2"));
        } catch (Exception e) {
            fail("Тест метода GET завершился с ошибкой: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода POST")
    public void testPostRequest() {
        try {
            Response response = RestAssured.given()
                    .contentType("application/json")
                    .body("{\"key1\": \"value1\", \"key2\": \"value2\"}")
                    .when()
                    .post(BASE_URL + "/post")
                    .then()
                    .statusCode(200)
                    .extract().response();

            assertEquals(200, response.getStatusCode());

            assertEquals("value1", response.jsonPath().getString("json.key1"));
            assertEquals("value2", response.jsonPath().getString("json.key2"));
        } catch (Exception e) {
            fail("Тест метода POST завершился с ошибкой: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода PUT")
    public void testPutRequest() {
        try {
            Response response = RestAssured.given()
                    .contentType("application/json")
                    .body("{\"key1\": \"newValue1\"}")
                    .when()
                    .put(BASE_URL + "/put")
                    .then()
                    .statusCode(200)
                    .extract().response();

            assertEquals(200, response.getStatusCode());

            assertEquals("newValue1", response.jsonPath().getString("json.key1"));
        } catch (Exception e) {
            fail("Тест метода PUT завершился с ошибкой: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода DELETE")
    public void testDeleteRequest() {
        try {
            Response response = RestAssured.given()
                    .when()
                    .delete(BASE_URL + "/delete")
                    .then()
                    .statusCode(200)
                    .extract().response();

            assertEquals(200, response.getStatusCode());
        } catch (Exception e) {
            fail("Тест метода DELETE завершился с ошибкой: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Тест метода PATCH")
    public void testPatchRequest() {
        try {
            Response response = RestAssured.given()
                    .contentType("application/json")
                    .body("{\"key1\": \"patchedValue1\"}")
                    .when()
                    .patch(BASE_URL + "/patch")
                    .then()
                    .statusCode(200)
                    .extract().response();

            assertEquals(200, response.getStatusCode());

            assertEquals("patchedValue1", response.jsonPath().getString("json.key1"));
        }catch (Exception e){
            fail("Тест метода PATCH завершился с ошибкой: " + e.getMessage());
        }
    }
}