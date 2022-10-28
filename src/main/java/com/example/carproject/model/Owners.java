package com.example.carproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Owners {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String firstName, lastName, address, city, email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Car car;


}