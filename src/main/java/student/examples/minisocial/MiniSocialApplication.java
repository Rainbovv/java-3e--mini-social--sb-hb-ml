package student.examples.minisocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

@EntityScan(basePackages = {"student.examples.minisocial.domain.entities"})
@ComponentScan(basePackages = {"student.examples.minisocial.*"})
@EnableJpaRepositories({"student.examples.minisocial.dao"})
public class MiniSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniSocialApplication.class, args);
	}
}
