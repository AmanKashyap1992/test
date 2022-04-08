package test.main;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
public class TestMainApplication extends SpringBootServletInitializer  implements ApplicationRunner{
	public static void main(String[] args) {  
        SpringApplication.run(TestMainApplication.class, args);		
    }
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TestMainApplication.class);
		}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
