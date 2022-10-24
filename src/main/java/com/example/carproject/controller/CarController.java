package com.example.carproject.controller;

import com.example.carproject.model.Car;
import com.example.carproject.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarController {

	private CarRepo carRepo;

	@Autowired
	public CarController(CarRepo carRepo) {
		this.carRepo = carRepo;
	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepo.findAll();
	}
	@PostMapping("/cars")
	public Car addCar(Car car) {
		return carRepo.save(car);
	}
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable Long id) {
		carRepo.deleteById(id);
	}

	@GetMapping("/cars/{id}")
	public Car getCar(@PathVariable Long id) {
		return carRepo.findById(id).get();
	}





}