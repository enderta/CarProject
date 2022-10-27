package com.example.carproject.repos;

import com.example.carproject.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owners, Long> {


}