package com.example.apitesterproject_2.ConstantsPackage;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

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
            "Widget", "Gizmo", "Thingamabob", "Doodad", "Doohickey",
            "Contraption", "Apparatus", "Gadget", "Gubbins", "Grommet"
    };
    private final String[] PRODUCT_BRANDS = {
            "Acme", "Initech", "Widgets Inc.", "TechCorp", "Gizmo Co.",
            "Thingamajigs Ltd.", "Doodad Enterprises", "Widget World", "Gadget Innovations"
    };
    private final String[] PRODUCT_DESCRIPTIONS = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
    };

}
