package wiremock;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
public class UserXMLTest {
  @BeforeClass
  public static void register() {
    new RegisterStub().register("user.xml", "/user", true);
  }

  @Test
  public void getUserStubTest() throws IOException {
    String filePath = Paths.get("src/test/resources/__files/user.xml").toString();
    String xml = Files.readString(Paths.get(filePath));
    XmlMapper xmlMapper = new XmlMapper();
    User expectedUser = xmlMapper.readValue(xml, User.class);

    User user = new UserService(true).getUserInfo();
    Assert.assertEquals(expectedUser, user);
  }
}
