package info.lavait.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/server")
public class ServerController {

    private static int count = 0;

    @GetMapping
    public String get() {
        log.info("Received a request: " + count);
        return "server " + count++;
    }
}
