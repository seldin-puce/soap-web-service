package io.github.seldinpuce.soap.client;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;
import xjs.generated.car.GetCarRequest;
import xjs.generated.car.GetCarResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class carClientIntegrationTest {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();


    @LocalServerPort
    private int port;

    @Before
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCarRequest.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void whenSendRequest_thenResponseIsNotNull() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetCarRequest request = new GetCarRequest();
        request.setCarIdentifier("a6");

        Object response = ws.marshalSendAndReceive("http://localhost:" + port + "/ws", request);

        assertThat(response).isNotNull();
    }

    @Test
    public void whenCarIdentifierIsA6_thenManufacturerIsAudi() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetCarRequest request = new GetCarRequest();
        request.setCarIdentifier("A6");

        GetCarResponse response = (GetCarResponse) ws.marshalSendAndReceive("http://localhost:" + port + "/ws", request);

        assertEquals("Audi", response.getCar().getManufacturer());
    }
}
