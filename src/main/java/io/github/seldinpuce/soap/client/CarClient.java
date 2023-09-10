package io.github.seldinpuce.soap.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import xjs.generated.car.GetCarResponse;

public class CarClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(CarClient.class);

    public GetCarResponse getCar(String carIdentifier) {
        logger.info("Requesting car with identifier: {}", carIdentifier);

        var request = new xjs.generated.car.GetCarRequest();
        request.setCarIdentifier(carIdentifier);

        return (GetCarResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request);
    }
}
