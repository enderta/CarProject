package com.example.carproject.controller;

import com.example.carproject.model.Owner;
import com.example.carproject.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OwnerController {

	private OwnerRepo ownerRepo;

	@Autowired
	public OwnerController(OwnerRepo ownerRepo) {
		this.ownerRepo = ownerRepo;
	}
	@GetMapping("/owners")
	public Iterable<Owner> getOwners() {
		return ownerRepo.findAll();
	}
	@PostMapping("/owners")
	public Owner addOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	@DeleteMapping("/owners/{id}")
	public void deleteOwner(@PathVariable Long id) {
		ownerRepo.deleteById(id);
	}
	@GetMapping("/owners/{id}")
	public Owner getOwner(@PathVariable Long id) {
		return ownerRepo.findById(id).get();
	}


}