package company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	//public static void main(String[] args){
		/*
		ResteasyClient client = new ResteasyClientBuilder().build();
		WebTarget target = client.target("http://127.0.0.1:9000/jaje");
		Response response = target.request().get();
		
		System.out.println(response.readEntity(String.class));
		*/
	//}
	
	@RequestMapping("/jaje")
	public String getJaja() {
		return "JAJE";
	}
}
