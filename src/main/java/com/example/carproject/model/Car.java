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

private long id;
private String brand, model, color, registerNumber;
private int year, price;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "owner")
private Owner owner;
}