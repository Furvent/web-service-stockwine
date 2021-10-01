package furvent.stockwine.webService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WebServiceApplication.class);
		app.setAdditionalProfiles("initData");
		app.run(args);
	}

}
