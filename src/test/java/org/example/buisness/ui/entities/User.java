package org.example.buisness.ui.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String website;
    private String password;
    private UsersRolesEnum role;

}
