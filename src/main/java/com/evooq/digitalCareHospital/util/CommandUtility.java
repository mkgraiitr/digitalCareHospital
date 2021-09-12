package com.evooq.digitalCareHospital.util;

import java.util.Map;
import java.util.Scanner;

import static com.evooq.digitalCareHospital.constants.CommandLineMessage.QUITING;


public class CommandUtility {

    public static void exitCommandLine(Scanner scanner) {
        scanner.close();
        System.out.println(QUITING.getValue());
        System.exit(0);
    }

    public static void printEndResult(Map<String, Long> resultMap) {
        System.out.println("F" + ":" + resultMap.getOrDefault("F", 0L) + "," +
                "H" + ":" + resultMap.getOrDefault("H", 0L) + "," +
                "D" + ":" + resultMap.getOrDefault("D", 0L) + "," +
                "T" + ":" + resultMap.getOrDefault("T", 0L) + "," +
                "X" + ":" + resultMap.getOrDefault("X", 0L) + ",");
    }
}
