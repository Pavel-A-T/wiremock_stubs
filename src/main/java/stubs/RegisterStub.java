package stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RegisterStub {
  public void register(String fileName, String pathURL, boolean isXml) {
    stubFor(get(pathURL).willReturn(aResponse()
        .withHeader("Content-Type", isXml ? "application/xml" : "application/json")
        .withBodyFile(fileName)
        .withStatus(200)
    ));
  }
}