package services;

import dto.Course;
import java.util.HashMap;
import java.util.List;

public class CoursesService extends AbsBaseService {
  public CoursesService() {
    super("/course/get/all");
  }

  public List<Course> getCoursesInfo() {
    return sendGetRequest("", List.class, new HashMap<>());
  }
}
