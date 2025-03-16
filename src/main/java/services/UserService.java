package services;

import dto.User;
import java.util.HashMap;

public class UserService extends AbsBaseService {
  public UserService() {
    super("/user");
  }

  public User getUserInfo() {
    return sendGetRequest("", User.class, new HashMap<>());
  }
}
