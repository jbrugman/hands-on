package nl.example.hello;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class McpTools {
  private final ResponsesClient responsesClient;

  public McpTools(ResponsesClient responsesClient) {
    this.responsesClient = responsesClient;
  }

  @McpTool(name = "echo", description = "Geeft de invoer terug met het voorvoegsel MCP Uitgevoerd.")
  public String echo(@McpToolParam(description = "De invoerstring") String input) {
    return "MCP Uitgevoerd: " + input;
  }

  @McpTool(name = "roundtrip", description = "Voer een actie uit op een ai model")
  public String roundtrip(@McpToolParam(description = "Het onderwerp", required = true) String input) {
    return responsesClient.respond(
        "Schrijf een korte uitleg (maximaal 100 woorden) of een kort verhaal over het volgende onderwerp: " + input,
        true);
  }
}
