package nl.example.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HelloController {
  private final ResponsesClient responsesClient;

  public HelloController(ResponsesClient responsesClient) {
    this.responsesClient = responsesClient;
  }

  @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    try {
      return responsesClient.respond("Say hello world in one short sentence.");
    } catch (RestClientException exception) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, exception.getMessage(), exception);
    }
  }
}
