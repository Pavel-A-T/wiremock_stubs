package wiremock;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import dto.Course;
import dto.Courses;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import services.CoursesXMLService;
import stubs.RegisterStub;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WireMockTest
public class CourseXMLTest {

  @BeforeClass
  public static void register() {
    new RegisterStub().register("courses.xml", "/course/get/all", true);
  }

  @Test
  public void getAllCoursesTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/courses.xml").toString();
    String xml = Files.readString(Paths.get(filePath));
    XmlMapper xmlMapper = new XmlMapper();
    Courses courses = xmlMapper.readValue(xml, Courses.class);
    Response actualAllCourses = new CoursesXMLService().getCourses();
    List<Course> actualCourses = xmlMapper.readValue(actualAllCourses.getBody().asString(), Courses.class).getCourses();
    assertThat(courses.getCourses()).containsExactlyInAnyOrderElementsOf(actualCourses);
  }
}

