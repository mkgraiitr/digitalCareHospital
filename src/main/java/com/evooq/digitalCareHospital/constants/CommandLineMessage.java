package com.evooq.digitalCareHospital.constants;

public enum CommandLineMessage {

    INVALID_INPUT("Please provide valid input\n"),
    EXCEED_INVALID_ATTEMPTS("Sorry you have made 3 invalid attempts.\n"),
    WELCOME_MSG("Dear user, welcome to Care Hospital. \n "),
    ENTER_PATIENT_AND_DRUGS("\nEnter patients' health status separated by comma in first parameter" +
            " AND drug codes separated by comma in second argument, for example F,F P,P \n" +
            "OR enter q to quit:: "),
    QUITING("Thanks for visiting Disgital Care Hospital. Hope you enjoyed!!\n");

    private final String value;

    CommandLineMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}

