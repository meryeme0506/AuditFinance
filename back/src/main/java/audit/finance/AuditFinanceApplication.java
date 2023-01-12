package audit.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AuditFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditFinanceApplication.class, args);
	}

}
