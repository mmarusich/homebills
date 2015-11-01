package com.homebills.entities.types;

/**
 * Created by maksm_000 on 03.08.2015.
 */
public enum Status {
    ACTIVE(0),
    DELETED(1);

    private int value;

    Status(int value) {
        this.value = value;
    }
}
