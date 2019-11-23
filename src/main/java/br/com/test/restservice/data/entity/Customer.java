package br.com.test.restservice.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private Date createdDate;
	private Date lastUpdated;
	private Boolean activated;
	
	private Customer() {}
	
	/**
	 * Construtor utilizado no pattern Builder
	 * @param id
	 * @param name
	 * @param description
	 * @param createdDate
	 * @param lastUpdated
	 * @param activated
	 */
	private Customer(Long id, String name, String description, Date createdDate, Date lastUpdated, Boolean activated) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
		this.activated = activated;
	}
	
	/**
	 * Utilizando padrao Builder
	 * @author Tony
	 *
	 */
	public static class CustomerBuilder {
		
		private Long id;
		private String name;
		private String description;
		private Date createdDate;
		private Date lastUpdated;
		private Boolean activated;
		
		public CustomerBuilder() {
		}

		public CustomerBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public CustomerBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public CustomerBuilder description(String description) {
			this.description = description;
			return this;
		}

		public CustomerBuilder createdDate(Date createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public CustomerBuilder lastUpdated(Date lastUpdated) {
			this.lastUpdated = lastUpdated;
			return this;
		}
		
		public CustomerBuilder activated(Boolean activated) {
			this.activated = activated;
			return this;
		}
		
		public Customer createCustomer() {
			return new Customer(id, name, description, createdDate, lastUpdated, activated);
		}
		
	}

}
