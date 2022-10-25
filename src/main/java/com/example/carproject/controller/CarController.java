package com.example.carproject.controller;

import com.example.carproject.model.Car;
import com.example.carproject.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarController {

	@Autowired
	private CarRepo carRepo;

	@GetMapping("/cars")

	@CrossOrigin(
			maxAge = 4800, allowCredentials = "false",
			allowedHeaders = {"*"})
	public Iterable<Car> getCars() {
		return carRepo.findAll();
	}
	@PostMapping(path="/cars", consumes = {"application/json"})
	@CrossOrigin()
	public Car createCar(@RequestBody Car car) {
		return carRepo.save(car);
	}
	@DeleteMapping(path = "/cars/{id}",consumes = {"application/json"})
	public void deleteCar(@PathVariable Long id) {
		carRepo.deleteById(id);
	}
	@GetMapping("/cars/{id}")
	public Car getCar(@PathVariable Long id) {
		return carRepo.findById(id).get();
	}






}