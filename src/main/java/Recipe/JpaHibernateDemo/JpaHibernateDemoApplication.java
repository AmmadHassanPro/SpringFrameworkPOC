package Recipe.JpaHibernateDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Recipe.JpaHibernateDemo")
public class JpaHibernateDemoApplication {

	public static void main(String[] args) {
		System.setProperty("http.agent", "Chrome");
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
		
	}
}
