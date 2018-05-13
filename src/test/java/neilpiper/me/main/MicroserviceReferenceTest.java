package neilpiper.me.main;

import static org.assertj.core.api.BDDAssertions.then;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
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
  @Ignore
  public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity =
        this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/info", Map.class);

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  @Ignore
  public void shouldReturn200WhenGettingInventorySummary() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
        "http://localhost:" + this.port + "/depot/111/invenvtory_summaries/10001", Map.class);
    
    //{id=10001, inventoryLocation=BRADFORD}

    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
