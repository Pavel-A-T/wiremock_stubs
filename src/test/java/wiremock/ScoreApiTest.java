package wiremock;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ScoreApiTest {
  @BeforeClass
  public static void register() {
    String name = "Test%20user";
    new RegisterStub().register("score.json", "/user/get/" + name);
  }
  @Test
  public void getAllCoursesTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/score.json").toString();
    String json = Files.readString(Paths.get(filePath));
    ObjectMapper objectMapper = new ObjectMapper();
    Score score = objectMapper.readValue(json, Score.class);

    Score actualScore = new ScoreService().getScoreInfo("Test user");
    Assert.assertEquals(score, actualScore);
  }
}
