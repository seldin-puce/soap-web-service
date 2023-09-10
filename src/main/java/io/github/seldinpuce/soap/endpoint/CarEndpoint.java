package io.github.seldinpuce.soap.endpoint;

import xjs.generated.car.GetAllCarsResponse;
import xjs.generated.car.GetCarRequest;
import io.github.seldinpuce.soap.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import xjs.generated.car.GetCarResponse;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "car.generated.xjs";

    private final CarService carService;

    @Autowired
    public CarEndpoint(CarService carService) {
        this.carService = carService;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCarRequest")
    @ResponsePayload
    public GetCarResponse getCarResponse(@RequestPayload GetCarRequest getCarRequest) {
        var response = new GetCarResponse();
        response.setCar(carService.getCar(getCarRequest.getCarIdentifier()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCarsRequest")
    @ResponsePayload
    public GetAllCarsResponse getAllCarsResponse() {
        var response = new GetAllCarsResponse();
        response.getCar().addAll(carService.getCars());

        return response;
    }
}
