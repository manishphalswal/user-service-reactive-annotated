package org.ipo.rwa.reactive.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class GeoLocation implements Serializable {
    private Double lat;
    private Double lng;
}
