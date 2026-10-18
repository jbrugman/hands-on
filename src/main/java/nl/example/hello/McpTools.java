package nl.example.hello;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class McpTools {
  @McpTool(name = "echo", description = "Geeft de invoer terug met het voorvoegsel MCP Uitgevoerd.")
  public String echo(@McpToolParam(description = "De invoerstring") String input) {
    return "MCP Uitgevoerd: " + input;
  }
}
