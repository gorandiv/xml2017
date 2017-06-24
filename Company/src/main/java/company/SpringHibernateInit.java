package company;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringHibernateInit {

	public static void main(String[] args) {
		companyA(args);
		companyB(args);
	}
	
	public static void companyA(String[] args) {
		SpringApplication app = new SpringApplication(SpringHibernateInit.class);
		Properties properties = new Properties();
		properties.put("server.port", "8100");
		properties.put("spring.datasource.platform", "a");
		app.setDefaultProperties(properties);
		app.run(args);
	}
	public static void companyB(String[] args) {
		SpringApplication app = new SpringApplication(SpringHibernateInit.class);
		Properties properties = new Properties();
		properties.put("server.port", "8101");
		properties.put("spring.datasource.platform", "b");
		app.setDefaultProperties(properties);
		app.run(args);
	}
}
