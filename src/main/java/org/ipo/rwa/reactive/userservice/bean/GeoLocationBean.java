package org.ipo.rwa.reactive.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class GeoLocationBean implements Serializable {
    private Double lat;
    private Double lng;
}
