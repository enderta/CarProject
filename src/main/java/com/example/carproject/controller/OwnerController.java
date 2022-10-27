package com.example.carproject.controller;

import com.example.carproject.model.Owners;
import com.example.carproject.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins="*", allowedHeaders="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OwnerController {

@Autowired
private OwnerRepo ownerRepo;

@GetMapping("/owners")
public ResponseEntity<?> getAllOwners() {
	return ResponseEntity.ok(ownerRepo.findAll());
}
@PostMapping("/owners")
public ResponseEntity<?> addOwner(@RequestBody Owners owner) {
	ownerRepo.save(owner);
	return ResponseEntity.status(201).body(owner);
}
@DeleteMapping("/owners/{id}")
public ResponseEntity<?> deleteOwner(@PathVariable long id) {
	ownerRepo.deleteById(id);
	if (ResponseEntity.status(204).build().getStatusCode().is2xxSuccessful()) {
		return ResponseEntity.status(204).build();
	}
	return ResponseEntity.status(400).build();

}
@GetMapping("/owners/{id}")
public ResponseEntity<?> getOwnerById(@PathVariable long id) {
	return ResponseEntity.ok(ownerRepo.findById(id));
}

}