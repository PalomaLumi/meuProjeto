package br.edu.ifrs.osorio.tads.palomalumi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringBootServletInitializer;

@SpringBootApplication
public class PalomalumiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PalomalumiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PalomalumiApplication.class);
    }
}
