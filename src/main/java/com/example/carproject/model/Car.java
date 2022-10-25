package com.example.carproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String brand, model, color,registerNumber;
private int year, price;



}