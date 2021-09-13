package com.evooq.digitalCareHospital.util;

import java.util.concurrent.ThreadLocalRandom;

public class HospitalUtil {

    public static boolean isFlyingSpaghettiNoodlePowerEnabled() {
        return 500000 == generateRandomNumber();
    }

    public static int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 1000000 + 1);
    }

    public static boolean areDrugsAvailable(String[] drugInput) {
        return drugInput.length > 1 && drugInput[1] != null && drugInput[1].length() > 0;
    }
}
