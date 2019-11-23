package br.com.test.restservice.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.restservice.data.entity.Customer;
import br.com.test.restservice.exception.CustomerNotFoundException;
import br.com.test.restservice.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerController {
	
	private final ICustomerService service;

	@Autowired
	CustomerController(final ICustomerService service) {
		this.service = service;
	}
	
	@GetMapping("/customers")
	List<Customer> all() {
		return service.findAll();
	}	
	
	@PostMapping("/customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
	    try {
			return service.save(newCustomer);
		} catch (Exception e) {
			log.error("Problema na chamada do metodo newCustomer.", e);
			return null;
		}
    }
	
	@GetMapping("/customers/{customersId}")
	Optional<Customer> one(@PathVariable Long customersId) {
		Optional<Customer> customer = service.findById(customersId);
		if (customer == null) {
			throw new CustomerNotFoundException(customersId);	
		}
		return customer;
	}	
	
	@PutMapping("/customers/{id}")
	Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		return service.replace(id, newCustomer); 
	}	
	
    @DeleteMapping("/employees/{id}")
	void deleteCustomer(@PathVariable Long id) {
    	service.deleteById(id);
	}
	
}
