package tech.pdai.springframework.dao;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;
import tech.pdai.springframework.entity.User;

/**
 * @author pdai
 */
@Repository
public class UserDaoImpl {

  /**
   * mocked to find user list.
   *
   * @return user list
   */
  public List<User> findUserList() {
    return Collections.singletonList(new User("pdai", 18));
  }
}
