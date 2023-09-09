//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.10 at 12:56:02 AM CEST 
//


package io.github.seldinpuce.soap.cars;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.github.seldinpuce.soap.cars package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.github.seldinpuce.soap.cars
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllCarsRequest }
     * 
     */
    public GetAllCarsRequest createGetAllCarsRequest() {
        return new GetAllCarsRequest();
    }

    /**
     * Create an instance of {@link GetAllCarsResponse }
     * 
     */
    public GetAllCarsResponse createGetAllCarsResponse() {
        return new GetAllCarsResponse();
    }

    /**
     * Create an instance of {@link Car }
     * 
     */
    public Car createCar() {
        return new Car();
    }

}
