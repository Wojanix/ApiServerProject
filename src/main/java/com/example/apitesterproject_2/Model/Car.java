package com.example.apitesterproject_2.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private boolean isAutomatic;
    private EngineType engineType;
    private int numberOfDoors;
    private int horsePower;
    private String fuelType;
    private boolean isConvertible;
    private boolean hasGPS;



}
