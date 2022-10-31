package com.example.carproject.controller;

import com.example.carproject.model.Owners;
import com.example.carproject.repos.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api",produces = "application/json")
@CrossOrigin(origins="*", allowedHeaders="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OwnerController {
@Autowired
private OwnerRepo ownerRepo;
@GetMapping("/owners")
public ResponseEntity<?> getAllOwners() {
	return ResponseEntity.ok(ownerRepo.findAll());
}
@PostMapping(path="/owners",consumes = "application/json")
public ResponseEntity<?> addOwner(@RequestBody Owners owner) {
	ownerRepo.save(owner);
	return ResponseEntity.status(201).body(owner);
}
@DeleteMapping("/owners/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public ResponseEntity<?> deleteOwner(@PathVariable long id) {
	ownerRepo.deleteById(id);
	if (ResponseEntity.status(204).build().getStatusCode().is2xxSuccessful()) {
		return ResponseEntity.status(204).build();
	}
	return ResponseEntity.status(400).build();
}
@GetMapping("/owners/{id}")
public ResponseEntity<?> getOwnerById(@PathVariable long id) {
	Owners owner = ownerRepo.findById(id);
	if (owner != null) {
		return ResponseEntity.ok(owner);
	}
	return ResponseEntity.status(404).build();
}
}