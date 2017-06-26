package bank;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringHibernateInit {

	public static void main(String[] args) {
		bankC(args);
		bankD(args);
	}
	
	public static void bankC(String[] args) {
		SpringApplication app = new SpringApplication(SpringHibernateInit.class);
		Properties properties = new Properties();
		properties.put("server.port", "8090");
		properties.put("spring.datasource.platform", "c");
		
		properties.setProperty("bankId", "1");
		
		app.setDefaultProperties(properties);
		app.run(args);
	}
	public static void bankD(String[] args) {
		SpringApplication app = new SpringApplication(SpringHibernateInit.class);
		Properties properties = new Properties();
		properties.put("server.port", "8091");
		properties.put("spring.datasource.platform", "d");
		
		properties.setProperty("bankId", "2");
		
		app.setDefaultProperties(properties);
		app.run(args);
	}
}


