package com.example.carproject.repos;

import com.example.carproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
@Component
public interface CarRepo extends JpaRepository<Car, Long> {
public Car save(Car car);
public Car findById(long id);
public void deleteById(long id);
public List<Car> findAll();






}