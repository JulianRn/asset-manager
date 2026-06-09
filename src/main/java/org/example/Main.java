package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.core.env.Environment;

import java.awt.*;
import java.net.URI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

@SpringBootApplication(
        exclude = {UserDetailsServiceAutoConfiguration.class},
        scanBasePackages = "org.example"
)
public class Main implements CommandLineRunner {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String port = environment.getProperty("local.server.port", "8080");
        String url = "http://localhost:" + port;

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        } else {
            try {
                new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url)
                        .start();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}