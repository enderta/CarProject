package com.example.carproject.repos;

import com.example.carproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo extends JpaRepository<Car, Long> {




}