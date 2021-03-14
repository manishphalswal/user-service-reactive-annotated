package org.ipo.rwa.reactive.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class Company implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;
}
