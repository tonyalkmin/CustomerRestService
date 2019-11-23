package br.com.test.restservice.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.test.restservice.data.entity.Customer;
import br.com.test.restservice.data.repository.CustomerRepository;
import br.com.test.restservice.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;

/**
 * Pequena Camada de Servicos para agregar regra de Negocio
 * @author Tony
 *
 */
@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Resource
	private CustomerRepository repository;
	
	CustomerServiceImpl() {	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) repository.findAll();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		if (id == null) {
			log.error("Id is required");
			return null;
		}
		
		return repository.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		if (customer == null) {
			log.error("Entity is required");
			return null;
		}
		
		return repository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		if (id == null) {
			log.error("id is required");
			return;
		}
		repository.deleteById(id);
	}
	
	
	@Override
	public Customer replace(Long id, Customer newCustomer) {
		if (id == null) {
			log.error("replace - id is Required");
			return null;
		}
		
		if (newCustomer == null) {
			log.error("replace - customer is Required");
			return null;
		}
		
		if (newCustomer.getId() == null) {
			log.error("replace - id customer is Required");
			return null;
		}

		return repository.findById(id)
	      .map(customer -> {
	    	  customer.setName(newCustomer.getName());
	    	  customer.setDescription(newCustomer.getDescription());
	    	  customer.setCreatedDate(new Date());
	    	  customer.setLastUpdated(new Date());
	    	  customer.setActivated(true);
	        return repository.save(customer);
	      })
	      .orElseGet(() -> {
	    	  newCustomer.setId(id);
	        return repository.save(newCustomer);
	      });		
	  }
}
