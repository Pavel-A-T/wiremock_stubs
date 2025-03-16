package services;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;
import java.util.Map;

public abstract class AbsBaseService {
  protected RequestSpecification requestSpecification;

  public AbsBaseService(String basePath) {
    this.requestSpecification = given()
        .baseUri(System.getProperty("baseURL", ConfigReader.getProperty("baseURL")))
        .basePath(basePath)
        .contentType("application/json");
  }

  protected <T> T sendGetRequest(String path, Class<T> responseType, Map<String, Object> pathParams) {
    return given()
        .spec(this.requestSpecification)
        .pathParams(pathParams)
        .get(path)
        .then()
        .statusCode(200)
        .extract()
        .as(responseType);
  }
}

