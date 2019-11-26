package br.com.test.restservice;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.test.restservice.data.entity.Customer;
import br.com.test.restservice.data.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LoadDatabase {

	// SpringBoot will run ALL CommandLineRunner beans once the application context is loaded.
	// So, we'll need a little data stored in DB before we begin
	@Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
	    return args -> {
	    	log.info("Preloading " + repository.save(Customer.builder().id(1l).name("Patricia Halfway").description("Customer 1").activated(true).build() ) );
	    	log.info("Preloading " + repository.save(Customer.builder().id(2l).name("Anthony O'Rourke").description("Customer 2").activated(true).build() ) );
	    	log.info("Preloading " + repository.save(Customer.builder().id(3l).name("Thomas Simpson").description("Customer 3").activated(true).build() ) );
	    };
	}
}
