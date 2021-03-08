package neilpiper.me;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
public class ExamplesTest {

  // this will run all *.feature files that exist in sub-directories
  // refer to https://github.com/intuit/karate#naming-conventions
  // for folder-structure recommendations and naming conventions

  
  @Autowired
  MicroserviceReference refClass;
  
  
  @BeforeClass
  public static void setup()
  {
    System.setProperty("server.port", "8090");
    MicroserviceReference.main(new String[] {});
  }
  


 @org.junit.Before
 public void preTest()
 {
   
 }

}
