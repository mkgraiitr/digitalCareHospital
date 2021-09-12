package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.constants.Drugs;
import com.evooq.digitalCareHospital.constants.PatientDischargeDetails;
import com.evooq.digitalCareHospital.domain.Drug;
import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.Pharmacy;

import java.util.ArrayList;
import java.util.List;

import static com.evooq.digitalCareHospital.constants.HealthState.getStateBySymbol;

public class HospitalManager {
    public Hospital buildHospitalDetails(String userInput) {
        System.out.println("getPrescriptionDetails:: " + userInput);
        Hospital hospital = Hospital.builder().build();
        String[] argumentArray = userInput.split(" ");
        System.out.println(argumentArray.length);
        if (argumentArray.length > 0) {
            String[] stateInput = argumentArray[0].split(",");
            List<Patient> patients = new ArrayList<>();

            for (String status : stateInput) {
                String healthState = getStateBySymbol(status);
                Patient patient = new Patient();
                patient.setHealthState(healthState);
                patients.add(patient);
            }
            System.out.println(patients.size());
            hospital.setPatients(patients);

            List<Drug> drugs = new ArrayList<>();
            List<String> prescribedDrug = new ArrayList<>();
            if (argumentArray.length > 1 && argumentArray[1] != null && argumentArray[1].length() > 0) {
                String[] drugInput = argumentArray[1].split(",");
                System.out.println("drugInput" + drugInput);
                for (String drug : drugInput) {
                    String drugName = Drugs.getDrugNameBySymbol(drug);
                    prescribedDrug.add(drugName);
                    drugs.add(Drug.builder().name(drugName).build());
                }
            }

            hospital.setPharmacy(Pharmacy.builder().drugs(drugs).build());
        }
        return hospital;
    }

    public PatientDischargeDetails getDischargeDetails(Patient patient) {
        return PatientDischargeDetails.builder().build();
    }
}
