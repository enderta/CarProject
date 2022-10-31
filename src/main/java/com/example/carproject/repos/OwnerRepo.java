package com.example.carproject.repos;

import com.example.carproject.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OwnerRepo extends JpaRepository<Owners, Long> {
public Owners save(Owners owner);
public Owners findById(long id);
public void deleteById(long id);
public List<Owners> findAll();
}