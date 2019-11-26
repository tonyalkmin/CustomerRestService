package br.com.test.restservice.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AbstractAuditable<U> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	@GeneratedValue
	private Long id;

	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date lastUpdated;
	
}
