package com.example.carproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "owners")
@Builder
public class Owners {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String firstName, lastName, address, city, email;
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "owner")
	@JsonManagedReference
		private Car car;


}