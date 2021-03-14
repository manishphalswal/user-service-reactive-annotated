package org.ipo.rwa.reactive.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class Address implements Serializable {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private Integer zipcode;
    private String country;

    private GeoLocation geoLocation;
}
