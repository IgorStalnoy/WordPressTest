package org.example.buisness.ui.elements;

public enum SideMenuSectionsEnum {
    DASHBOARD("Dashboard"), POSTS("Posts"), MEDIA("Media"), PAGES("Pages"), COMMENTS("Comments"), APPEARANCE("Appearance"), PLUGINS("Plugins"),
    USERS("Users"), TOOLS("Tools"), SETTINGS("Settings"), PERFORMANCE("Performance"), SMUSH("Smush"), COLLAPSE_MENU("Collapse menu");

    private final String value;

    SideMenuSectionsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
