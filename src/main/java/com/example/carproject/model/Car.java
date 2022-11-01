package com.example.carproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
@Builder
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String brand, model, color,registerNumber;
private int year, price;
@ManyToOne
@JoinColumn(name = "owner_id")
@JsonBackReference
private Owners owner;


}