package com.example.carproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "owners")
public class Owners {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String firstName, lastName, address, city, email;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "owner")
	@JsonManagedReference
		private Car car;


}