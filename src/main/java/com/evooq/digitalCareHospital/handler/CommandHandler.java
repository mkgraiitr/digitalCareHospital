package com.evooq.digitalCareHospital.handler;

import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.service.HospitalManager;
import com.evooq.digitalCareHospital.service.PatientManager;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.evooq.digitalCareHospital.constants.CommandLineMessage.*;
import static com.evooq.digitalCareHospital.util.CommandUtility.exitCommandLine;
import static com.evooq.digitalCareHospital.util.CommandUtility.printEndResult;


public class CommandHandler implements Handler {
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public void handle() {
        System.out.println(WELCOME_MSG.getValue());
        boolean isCommandLineActive = true;
        while (isCommandLineActive) {
            try {
                System.out.println(ENTER_PATIENT_AND_DRUGS.getValue());
                String userInput = scanner.next();
                if (userInput.equals("q")) {
                    isCommandLineActive = false;
                    exitCommandLine(scanner);
                }
                HospitalManager hospitalManager = new HospitalManager();
                hospitalManager.simulateHospital(userInput);

            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT.getValue());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("error occurred " + e.toString() + ", " + INVALID_INPUT.getValue());
                scanner.nextLine();
            }
        }
    }
}
