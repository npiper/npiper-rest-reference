package neilpiper.me.demo.service;

import java.util.Arrays;
import java.util.List;
import neilpiper.me.demo.api.UsersApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsersApiDelegateImpl implements UsersApiDelegate {


  @Override
  public ResponseEntity<List<String>> usersGet() {

    try {
      List<String> listOfUsers = Arrays.asList(new String[] {"User A", "User B"});
      return new ResponseEntity<List<String>>(listOfUsers, HttpStatus.OK);
    } catch (RuntimeException e) {
      log.error("Couldn't serialize response for content type application/json", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }


}
