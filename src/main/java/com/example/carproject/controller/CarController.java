package com.example.carproject.controller;

import com.example.carproject.model.Car;
import com.example.carproject.repos.CarRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins="*", allowedHeaders="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CarController {

@Autowired
private CarRepo carRepo;


@GetMapping("/cars")
public ResponseEntity<?> getAllCars() {
	return ResponseEntity.ok(carRepo.findAll());
}

@PostMapping("/cars")
public ResponseEntity<?> addCar(@RequestBody Car car) {
	carRepo.save(car);
	return ResponseEntity.status(201).body(car);}

@DeleteMapping("/cars/{id}")
public ResponseEntity<?> deleteCar(@PathVariable long id) {
	carRepo.deleteById(id);
	if (ResponseEntity.status(204).build().getStatusCode().is2xxSuccessful()) {
		return ResponseEntity.status(204).build();
	}
	return ResponseEntity.status(400).build();
}
@GetMapping("/cars/{id}")
public ResponseEntity<?> getCarById(@PathVariable long id) {
	return ResponseEntity.ok(carRepo.findById(id));
}



}