package com.example.carproject.controller;

import com.example.carproject.model.Car;
import com.example.carproject.repos.CarRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/api", produces = "application/json")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CarController {


private CarRepo carRepo;


@GetMapping("/cars")
public ResponseEntity<?> getAllCars() {
	return ResponseEntity.ok(carRepo.findAll());
}

@PostMapping(path="/cars",consumes = "application/json")
@ResponseStatus(HttpStatus.CREATED)
public ResponseEntity<?> addCar(@RequestBody Car car) {
	carRepo.save(car);
	return ResponseEntity.status(201).body(car);
}

@DeleteMapping("/cars/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public ResponseEntity<?> deleteCar(@PathVariable long id) {
	carRepo.deleteById(id);
	if (ResponseEntity.status(204).build().getStatusCode().is2xxSuccessful()) {
		return ResponseEntity.status(204).build();
	}
	return ResponseEntity.status(400).build();
}

@GetMapping("/cars/{id}")
public ResponseEntity<?> getCarById(@PathVariable long id) {
	Car car = carRepo.findById(id);
	if (car != null) {
		return ResponseEntity.ok(car);
	}
	return ResponseEntity.status(404).build();
}


}