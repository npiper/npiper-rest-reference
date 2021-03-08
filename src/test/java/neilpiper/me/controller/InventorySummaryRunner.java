package neilpiper.me.controller;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import neilpiper.me.MicroserviceReference;

//@RunWith(Karate.class)
//@CucumberOptions(features = "classpath:neilpiper/me/controller/karate")
public class InventorySummaryRunner {
  
  @Autowired
  MicroserviceReference refClass;
  
  
  @BeforeClass
  public static void setup()
  {
  //  System.setProperty("server.port", "8090");
   // MicroserviceReference.main(new String[] {});
  }
  


 @org.junit.Before
 public void preTest()
 {
   
 }

}
