package in.assignment02.springbootmongodbppa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
public class validationConfig {

	@Bean
	public ValidatingMongoEventListner validationMongoEventListner() {
		return new ValidatingMongoEventListner(validator());
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
}
