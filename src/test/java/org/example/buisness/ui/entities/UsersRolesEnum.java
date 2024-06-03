package org.example.buisness.ui.entities;

public enum UsersRolesEnum {
    SUBSCRIBER("Subscriber"),CONTRIBUTOR("Contributor"),AUTHOR("Author"),EDITOR("Editor"),ADMINISTRATOR("Administrator");
    private final String value;
    UsersRolesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
