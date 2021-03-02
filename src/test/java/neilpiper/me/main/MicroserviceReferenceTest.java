package neilpiper.me.main;

import static org.assertj.core.api.BDDAssertions.then;
import java.net.URI;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * Basic mocked integration tests.
 * 
 * @author neilpiper
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class MicroserviceReferenceTest {

  @LocalServerPort
  private int port;

  @Value("${local.management.port}")
  private int mgt;

  @Resource
  private WebApplicationContext webApplicationContext;

  @Autowired
  private TestRestTemplate testRestTemplate;


  @Test
  public void shoudReturn200WhenGettingUserAPI() throws Exception
  {
    
    
    
        RequestEntity<Void> request = RequestEntity.get(new URI("http://localhost:" + this.mgt + "/users")).build();
        ParameterizedTypeReference<List<String>> listOfUsers = new ParameterizedTypeReference<List<String>>() {};
        ResponseEntity<List<String>> response = testRestTemplate.exchange(request, listOfUsers);
    
    //this.testRestTemplate.getForObject("http://localhost:" + this.mgt + "/users", List.class,null);

    //ResponseEntity<List<String>> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/users", List.class, null);
    
     //ResponseEntity<List<String>> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/users", List.class);
     then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
  }

  @Test
  public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity =
        this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/actuator/info", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  public void shouldReturn200WhenGettingInventorySummary() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
        "http://localhost:" + this.port + "/depot/111/inventory_summaries/10001", Map.class);

    // {id=10001, inventoryLocation=BRADFORD}

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
