package org.ipo.rwa.reactive.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class CompanyBean implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;
}
