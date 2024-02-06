package com.example.apitesterproject_2.Controller;
import com.example.apitesterproject_2.ConstantsPackage.Constants;
import com.example.apitesterproject_2.Model.Car;
import com.example.apitesterproject_2.Model.EngineType;
import com.example.apitesterproject_2.Model.shop.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/listcontroller")
@RequiredArgsConstructor
public class ListController {
    private final Constants constants;

    @RequestMapping("/getCarsList/{amount}")
    ResponseEntity<?> getProductsList(@PathVariable Integer amount){
        List<Car> carsList = new ArrayList<>();

        String[] colors = constants.getCOLORS();
        String[] brands = constants.getBRANDS();
        String[] fuelTypes = constants.getFUELTYPES();


        Car[] cars = new Car[amount];
        Random random = new Random();

        for (int i = 0; i < cars.length; i++) {
            String brand = brands[random.nextInt(brands.length)];
            Car car = new Car(
                    brand,
                    Constants.getRandomModel(brand),
                    2002 + random.nextInt(22),
                    colors[random.nextInt(colors.length)],
                    2000 + random.nextDouble() * 50000,
                    random.nextBoolean(),
                    EngineType.values()[random.nextInt(EngineType.values().length)],
                    2 + random.nextInt(4),
                    100 + random.nextInt(401),
                    fuelTypes[random.nextInt(fuelTypes.length)],
                    random.nextBoolean(),
                    random.nextBoolean()
            );
            carsList.add(car);
        }

        return ResponseEntity.ok(carsList);
    }

    @RequestMapping("/getProductList/{amount}")
    ResponseEntity<?> getProductList(@PathVariable int amount) {
        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Product product = Product.builder()
                    .price(generateRandomNumber(1, 200))
                    .productBrand(constants.getPRODUCT_BRANDS()[generateRandomNumber(0, constants.getPRODUCT_BRANDS().length)])
                    .productDescription(constants.getPRODUCT_DESCRIPTIONS()[generateRandomNumber(0, constants.getPRODUCT_DESCRIPTIONS().length)])
                    .productName(constants.getPRODUCT_NAMES()[generateRandomNumber(0, constants.getPRODUCT_NAMES().length)])
                    .build();

            productList.add(product);
        }
        //check shit if work github
        return ResponseEntity.ok(productList);
    }

    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}

