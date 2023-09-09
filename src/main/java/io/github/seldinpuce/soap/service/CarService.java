package io.github.seldinpuce.soap.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.seldinpuce.soap.cars.Car;

@Service
public class CarService {
    private static final Map<String, Car> cars = new HashMap<>();


    @PostConstruct
    public void initData() {

        var car1 = new Car();
        car1.setName("A6");
        car1.setColor("Black");
        car1.setManufacturer("Audi");
        car1.setPrice(10000);
        car1.setEngineVolume(3.0f);
        car1.setYear(2016);
        cars.put(car1.getName(), car1);

        var car2 = new Car();
        car2.setName("A4");
        car2.setColor("White");
        car2.setManufacturer("Audi");
        car2.setPrice(8000);
        car2.setEngineVolume(2.0f);
        car2.setYear(2014);
        cars.put(car2.getName(), car2);

        var car3 = new Car();
        car3.setName("A3");
        car3.setColor("Red");
        car3.setManufacturer("Audi");
        car3.setPrice(6000);
        car3.setEngineVolume(1.8f);
        car3.setYear(2012);
        cars.put(car3.getName(), car3);

        var car4 = new Car();
        car4.setName("C Class");
        car4.setColor("Black");
        car4.setManufacturer("Mercedes");
        car4.setPrice(12000);
        car4.setEngineVolume(2.0f);
        car4.setYear(2016);
        cars.put(car4.getName(), car4);

        var car5 = new Car();
        car5.setName("E Class");
        car5.setColor("White");
        car5.setManufacturer("Mercedes");
        car5.setPrice(10000);
        car5.setEngineVolume(2.2f);
        car5.setYear(2014);
        cars.put(car5.getName(), car5);

    }

    public Car getCar(String name) {
        return cars.get(name);
    }

    public List<Car> getCars() {
        return List.copyOf(cars.values());
    }
}
