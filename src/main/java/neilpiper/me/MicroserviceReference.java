package neilpiper.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import com.google.common.base.Predicates;
import neilpiper.me.demo.controller.InventorySummaryResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring application reference for the Microservice base package.
 * 
 * @author neilpiper
 *
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {InventorySummaryResource.class})
public class MicroserviceReference implements CommandLineRunner {

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

  /**
   * Creates the swagger configuration bean.
   * 
   * @return Docket response
   */
  @Bean
  public Docket appApi() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .paths(Predicates.not(PathSelectors.regex("/health"))).build();



  }

  public void run(String... arg0) throws Exception {
    // TODO Auto-generated method stub

  }



}
