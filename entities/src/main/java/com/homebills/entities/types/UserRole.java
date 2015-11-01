package com.homebills.entities.types;

/**
 * @author Maxim Marusich
 */
public enum UserRole {

    /**
     * Role admin
     */
    ROLE_ADMIN(0),
    /**
     * Role user
     */
    ROLE_USER(1);
    private int value;

    UserRole(int code) {
        this.value = code;
    }

    /**
     * Gets UserRole value
     *
     * @return UserRole value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets UserRole value
     *
     * @param value New UserRole value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Converts int value to UserRole value
     *
     * @param code Value to convert
     * @return Converted value
     */
    public static UserRole parse(int code) {
        for (UserRole role : UserRole.values()) {
            if (role.value == code) {
                return role;
            }
        }
        return UserRole.ROLE_USER;
    }
}
