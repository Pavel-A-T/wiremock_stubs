package wiremock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import dto.Course;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.CoursesService;
import stubs.RegisterStub;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WireMockTest
public class CoursesAPITest {
  @BeforeClass
  public static void register() {
    new RegisterStub().register("courses.json", "/course/get/all");
  }
  @Test
  public void getAllCoursesTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/courses.json").toString();
    String json = Files.readString(Paths.get(filePath));
    ObjectMapper objectMapper = new ObjectMapper();
    List<Course> courses = objectMapper.readValue(json, List.class);

    List<Course> actualAllCourses = new CoursesService().getCoursesInfo();
    Assert.assertEquals(courses, actualAllCourses);
  }
}
