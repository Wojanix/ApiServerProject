package com.example.apitesterproject_2.Response;


import com.example.apitesterproject_2.Model.Car;
import com.example.apitesterproject_2.Model.EngineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
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




    public static CarResponse fromFlightSearch(Car car){
        return CarResponse
                .builder()
                .brand(car.getBrand())
                .color(car.getColor())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .isAutomatic(car.isAutomatic())
                .engineType(car.getEngineType())
                .numberOfDoors(car.getNumberOfDoors())
                .horsePower(car.getHorsePower())
                .fuelType(car.getFuelType())
                .isConvertible(car.isConvertible())
                .hasGPS(car.isHasGPS())
                .build();
    }
}
