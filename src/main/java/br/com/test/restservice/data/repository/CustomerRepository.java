package br.com.test.restservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.test.restservice.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
