package com.evooq.digitalCareHospital.constants;

public enum SideEffect {
    FEVER("Fever"),
    NONE("None"),
    HEADACHE("Headache"),
    DEAD("Dead");

    private final String state;

    SideEffect(String state) {
        this.state = state;
    }

}
