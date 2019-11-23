package br.com.test.restservice.service;

import java.util.List;
import java.util.Optional;

import br.com.test.restservice.data.entity.Customer;

public interface ICustomerService {

	public List<Customer> findAll();
	
	public Optional<Customer> findById(Long id);
	
	public Customer save(Customer customer);
	
	public void deleteById(Long id);
	
	Customer replace(Long id, Customer customer);
	
}
