package services;

import dto.Score;
import java.util.HashMap;
import java.util.Map;

public class ScoreService extends AbsBaseService {
  public ScoreService() {
    super("/user/get/{name}");
  }

  public Score getScoreInfo(String name) {
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    return sendGetRequest("", Score.class, params);
  }
}
