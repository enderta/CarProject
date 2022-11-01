package com.example.carproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Car> cars;


}