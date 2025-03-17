package services;

import io.restassured.response.Response;

public class CoursesXMLService extends AbsBaseService {
  public CoursesXMLService() {
    super("/course/get/all", true);
  }

  public Response getCourses() {
    return sendGetRequest();
  }
}
