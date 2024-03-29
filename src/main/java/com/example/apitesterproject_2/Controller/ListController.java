package com.example.apitesterproject_2.Controller;
import com.example.apitesterproject_2.ConstantsPackage.Constants;
import com.example.apitesterproject_2.Model.CarModels.Car;
import com.example.apitesterproject_2.Model.CarModels.EngineType;
import com.example.apitesterproject_2.Model.shop.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/listcontroller")
@RequiredArgsConstructor
@Controller
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
    ResponseEntity<?> getProductList(@PathVariable int amount) throws IOException {
        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            if(i==constants.getPRODUCT_BRANDS().length){
                return ResponseEntity.ok().body(productList);
            }
            Product product = Product.builder()
                    .price(generateRandomNumber(1, 200))
                    .productBrand(constants.getPRODUCT_BRANDS()[i])
                    .productDescription(constants.getPRODUCT_DESCRIPTIONS()[i])
                    .productName(constants.getPRODUCT_NAMES()[i])
                    .imageLink(constants.getPRODUCT_IMAGES()[i])
                    .build();

            productList.add(product);
        }
        //check shit if work githubasfassafasff
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping(value = "/getImage/{imageLink}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getPng(@PathVariable String imageLink) throws IOException {
        String modifiedString = imageLink.replace('-', '/');
        byte[] response = getClass().getResourceAsStream(modifiedString).readAllBytes();
        return response;
    }


    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}

