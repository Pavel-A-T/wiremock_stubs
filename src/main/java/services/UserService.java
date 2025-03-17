package services;

import dto.User;
import java.util.HashMap;

public class UserService extends AbsBaseService {
  public UserService(boolean isXml) {
    super("/user", isXml);
  }

  public User getUserInfo() {
    return sendGetRequest("", User.class, new HashMap<>());
  }
}
