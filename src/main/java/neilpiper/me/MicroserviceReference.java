package neilpiper.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.codec.ServerCodecConfigurer;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


/**
 * Spring application reference for the Microservice base package.
 * 
 * @author neilpiper
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {"neilpiper.me.demo.controller","neilpiper.me.demo.api","neilpiper.me.demo.service"})
public class MicroserviceReference {

  @Autowired
  Environment environment;

  /**
   * Main method.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(MicroserviceReference.class, args);
  }




  @Bean
  public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
      return new OpenAPI()
              .components(new Components())
              .info(new Info().title("Books API").version(appVersion)
                      .license(new License().name("Apache 2.0").url("http://springdoc.org")));
  }
  


  @Bean
  public ServerCodecConfigurer serverCodecConfigurer() {
     return ServerCodecConfigurer.create();
  }
  
 



}
