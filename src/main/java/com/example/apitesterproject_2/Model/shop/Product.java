package com.example.apitesterproject_2.Model.shop;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private float price;
    private String productName;
    private String productBrand;
    private String productDescription;
}