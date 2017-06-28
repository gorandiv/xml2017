package company;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		properties.setProperty("companyId", "1");
		properties.setProperty("companyPib", "11111111111");
		properties.setProperty("companyName", "A");
		
		app.setDefaultProperties(properties);
		
		app.run(args);
	}
	public static void companyB(String[] args) {
		SpringApplication app = new SpringApplication(SpringHibernateInit.class);
		Properties properties = new Properties();
		properties.put("server.port", "8101");
		properties.put("spring.datasource.platform", "b");
		
		properties.setProperty("companyId", "2");
		properties.setProperty("companyPib", "22222222222");
		properties.setProperty("companyName", "B");
		
		app.setDefaultProperties(properties);
		
		app.run(args);
	}
}
