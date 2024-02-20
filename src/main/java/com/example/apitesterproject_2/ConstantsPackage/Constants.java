package com.example.apitesterproject_2.ConstantsPackage;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

@Service
@Data
public class Constants {

    public static String getRandomModel(String keyBrand){
        Random random = new Random();
        Map<String, List<String>> carMap = new HashMap<>();

        carMap.put("Toyota",  List.of("Camry", "Corolla", "Rav4", "Prius", "Highlander"));
        carMap.put("Ford",  List.of("Fusion", "Focus", "Escape", "Mustang", "Explorer"));
        carMap.put("Honda",  List.of("Civic", "Accord", "CR-V", "Pilot", "Odyssey"));
        carMap.put("Chevrolet",  List.of("Malibu", "Cruze", "Equinox", "Silverado", "Tahoe"));
        carMap.put("BMW",  List.of("3 Series", "5 Series", "X3", "X5", "M3"));
        carMap.put("Mercedes-Benz",  List.of("C-Class", "E-Class", "GLC", "GLE", "S-Class"));
        carMap.put("Nissan",  List.of("Altima", "Maxima", "Rogue", "Pathfinder", "Titan"));
        carMap.put("Tesla",  List.of("Model S", "Model 3", "Model X", "Model Y", "Cybertruck"));
        carMap.put("Audi",  List.of("A4", "A6", "Q5", "Q7", "R8"));
        carMap.put("Hyundai",  List.of("Elantra", "Sonata", "Tucson", "Santa Fe", "Kona"));
        carMap.put("Kia",  List.of("Optima", "Sorento", "Sportage", "Telluride", "Soul"));
        carMap.put("Subaru",  List.of("Outback", "Forester", "Impreza", "Crosstrek", "Legacy"));
        carMap.put("Volkswagen",  List.of("Jetta", "Passat", "Tiguan", "Atlas", "Golf"));
        carMap.put("Lexus",  List.of("ES", "RX", "NX", "LS", "GX", "RCF"));
        carMap.put("Mazda",  List.of("Mazda3", "Mazda6", "CX-5", "CX-9", "MX-5"));


        return carMap.get(keyBrand).get(random.nextInt(5));
    }
    private final String[] BRANDS = {
            "Toyota", "Ford", "Honda", "Chevrolet", "BMW",
            "Mercedes-Benz", "Nissan", "Tesla", "Audi", "Hyundai",
            "Kia", "Subaru", "Volkswagen", "Lexus", "Mazda"
    };
    private final String[] COLORS = {"Red", "Blue", "Black", "White"};
    private final String[] FUELTYPES = {"Gasoline", "Diesel", "Electric", "Hybrid"};


    // products
    private final String[] PRODUCT_NAMES = {
            "Nike Blazers",
            "Nike Air Force 1'07",
            "Nike Jordan High",
            "Nike Air Force Marshmallow",
            "Nike Air Force 1",
            "Nike Dunk High",
            "Nike Dunk Low"

    };
    private final String[] PRODUCT_BRANDS = {
            "Nike",
            "Nike",
            "Nike",
            "Nike",
            "Nike",
            "Nike",
            "Nike"
    };
    private final String[] PRODUCT_DESCRIPTIONS = {
            "Man Shoes Nike Blazers",
            "Man Shoes Nike Air Force 1'07",
            "Woman Shoes Nike Jordan High Blue",
            "Unisex Shoes Nike Air Force Marshmallow",
            "Woman Shoes Nike Air Force 1",
            "Man Shoes Nike Dunk High Aluminum",
            "Woman Shoes Nike Dunk Low Grey"
    };

    private final String[] PRODUCT_IMAGES = {
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_BLAZERS.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_AIR_FORCE_1_07.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_JORDAN_HIGH_BLUE.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_AIR_FORCE_MARSHMALLOW.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_AIR_FORCE_1_LOW_BLUE.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_DUNK_HIGH_ALUMINUM.png",
            "localhost:8080/listcontroller/getImage/classpath::images/products/NIKE_DUNK_LOW_GREY.png",
    };

}
