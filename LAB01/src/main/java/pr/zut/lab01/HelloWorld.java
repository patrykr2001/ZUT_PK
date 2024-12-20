package pr.zut.lab01;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
    @RequestMapping("/") String home() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }
}