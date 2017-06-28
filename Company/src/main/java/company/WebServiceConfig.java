package company;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "nalog_za_prenos")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("NalogPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/nalogZaPrenos");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "zahtev_za_izvod")
	public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ZahtevPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/ZahtevZaIzvod");
		wsdl11Definition.setSchema(countriesSchema);
		return wsdl11Definition;
	}
	
	@Bean(name = "nalogZaPrenos")
	public Wsdl11Definition defaultWsdl11Definition1() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("NalogZaPrenos.xsd"));

		return wsdl11Definition;
	}
	
	@Bean(name = "zahtevZaIzvod")
	public Wsdl11Definition defaultWsdl11Definition2() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("ZahtevZaIzvod.xsd"));

		return wsdl11Definition;
	}
	
	@Bean(name = "presek")
	public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PresekPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/presek");
		wsdl11Definition.setSchema(schema);
		return wsdl11Definition;
	}

	@Bean(name = "Presek")
	public Wsdl11Definition defaultWsdl11Definition3() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("Presek.xsd"));

		return wsdl11Definition;
	}
	
	
}