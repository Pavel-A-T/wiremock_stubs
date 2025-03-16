package stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RegisterStub {
  public void register(String fileName, String pathURL) {
    stubFor(get(pathURL).willReturn(aResponse()
        .withHeader("Content-Type", "application/json")
        .withBodyFile(fileName)
        .withStatus(200)
    ));
  }
}
