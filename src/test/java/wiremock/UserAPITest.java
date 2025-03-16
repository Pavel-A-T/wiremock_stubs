package wiremock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import dto.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import services.UserService;
import stubs.RegisterStub;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WireMockTest
public class UserAPITest {

  @BeforeClass
  public static void register() {
    new RegisterStub().register("user.json", "/user");
  }

  @Test
  public void getUserStubTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/user.json").toString();
    String json = Files.readString(Paths.get(filePath));
    // Преобразуем JSON в объект User
    ObjectMapper objectMapper = new ObjectMapper();
    User expectedUser = objectMapper.readValue(json, User.class);

    User user = new UserService().getUserInfo();
    Assert.assertEquals(expectedUser, user);
  }
}