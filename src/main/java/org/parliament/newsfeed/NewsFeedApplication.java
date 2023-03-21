package org.parliament.newsfeed;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Parliament NewsFeed API", version = "1.0.0", description = "Parliament NewsFeed API"))
public class NewsFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);
    }

    @RequestMapping("/")
    public RedirectView homeRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/api-doc");
        return redirectView;
    }
}
