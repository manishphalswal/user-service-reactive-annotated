package org.ipo.rwa.reactive.userservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class UserBean implements Serializable {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String phone;
    private String email;

    private AddressBean address;

    private String occupation;
    private String website;

    private CompanyBean company;

}
