package dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@JacksonXmlRootElement(localName = "Courses")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "Course")
  private List<Course> courses;

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}

