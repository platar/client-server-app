package info.lavait.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private String serverUrl;
    private final RestTemplate restTemplate;

    public ClientController(@Value("${clients.server.url}") String serverUrl,
                            RestTemplate restTemplate) {
        this.serverUrl = serverUrl;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get() {
        return "client";
    }

    @GetMapping("server")
    public String getServer() {
        String url = serverUrl + "/api/v1/server";
        log.info("Calling url: " + url);
        return restTemplate.getForObject(url, String.class);
    }
}
