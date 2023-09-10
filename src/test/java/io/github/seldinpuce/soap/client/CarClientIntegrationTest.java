package io.github.seldinpuce.soap.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class CarClientIntegrationTest {

    @Autowired
    CarClient carClient;


    @Test
    public void whenSendRequest_thenResponseIsNotNull() {
        var car = carClient.getCar("A6");
        assertThat(car).isNotNull();
    }

    @Test
    public void whenCarIdentifierIsA6_thenManufacturerIsAudi() {
        var car = carClient.getCar("A6");
        assertEquals("Audi", car.getCar().getManufacturer());
    }

    @Test
    public void whenGetAllCarsResultIsArrayOfCars() {
        var cars = carClient.getAllCars();
        var carList = cars.getCar();
        assertThat(carList).allSatisfy(car -> assertThat(car).isInstanceOf(xjs.generated.car.Car.class));
    }
}
