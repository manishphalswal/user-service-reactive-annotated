package org.ipo.rwa.reactive.userservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String phone;
    private String email;

    private Address address;

    private String occupation;
    private String website;

    private Company company;

}
