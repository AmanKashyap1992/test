package test.main;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScans(value = { 
		 @ComponentScan("boot.entry"), 
		 @ComponentScan("test")
		 //@ComponentScan("test.service"),
		// @ComponentScan("test.dao")
		})
public class Config {

}