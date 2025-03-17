package services;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public abstract class AbsBaseService {
  protected RequestSpecification requestSpecification;

  public AbsBaseService(String basePath, boolean isXml) {
    this.requestSpecification = given()
        .baseUri(System.getProperty("baseURL", ConfigReader.getProperty("baseURL")))
        .basePath(basePath)
        .contentType(isXml ? "application/xml" : "application/json")
        .header("Accept", isXml ? "application/xml" : "application/json");
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
  protected Response sendGetRequest() {
    return given()
        .spec(this.requestSpecification)
        .get()
        .then()
        .statusCode(200)
        .extract()
        .response();
  }
}

