package imie.tp.galactic.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

@SpringBootApplication
public class GalacticWsApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                final String[] methods = new String[] {"GET", "POST", "PUT", "DELETE"};
                registry
                        .addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods(methods);
            }
        };
    }

	public static void main(String[] args) {

		SpringApplication.run(GalacticWsApplication.class, args);
	}
}
