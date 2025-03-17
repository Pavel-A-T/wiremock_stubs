package wiremock;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import dto.Score;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.ScoreService;
import stubs.RegisterStub;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WireMockTest
public class ScoreXMLTest {

  @BeforeClass
  public static void register() {
    String name = "Test%20user";
    new RegisterStub().register("score.xml", "/user/get/" + name, true);
  }

  @Test
  public void getAllCoursesTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/score.xml").toString();
    String xml = Files.readString(Paths.get(filePath));
    XmlMapper xmlMapper = new XmlMapper();
    Score expectedScore = xmlMapper.readValue(xml, Score.class);
    Score actualScore = new ScoreService(true).getScoreInfo("Test user");
    Assert.assertEquals(expectedScore, actualScore);
  }
}

