package neilpiper.me.controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import neilpiper.me.MicroserviceReference;

@RunWith(Karate.class)
public class InventorySummaryRunner {
  
  static ConfigurableApplicationContext appContext;
  
  @BeforeClass
  public static void startup()
  {
    System.setProperty("server.port", "8090");
    appContext = SpringApplication.run(MicroserviceReference.class);
    
    
  }
  
  @AfterClass
  public static void tearDown()
  {
    InventorySummaryRunner.appContext.stop();
  }
  


}