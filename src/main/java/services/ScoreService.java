package services;

import dto.Score;
import java.util.HashMap;
import java.util.Map;

public class ScoreService extends AbsBaseService {
  public ScoreService(boolean isXml) {
    super("/user/get/{name}", isXml);
  }

  public Score getScoreInfo(String name) {
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    return sendGetRequest("", Score.class, params);
  }
}
