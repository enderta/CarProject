package com.example.carproject.repos;

import com.example.carproject.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepo extends JpaRepository<Owner, Long> {



}