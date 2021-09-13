package com.evooq.digitalCareHospital.util;

import com.evooq.digitalCareHospital.constants.Drugs;
import com.evooq.digitalCareHospital.domain.Drug;
import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.Pharmacy;

import java.util.ArrayList;
import java.util.List;

import static com.evooq.digitalCareHospital.constants.HealthState.getStateBySymbol;
import static com.evooq.digitalCareHospital.util.HospitalUtil.areDrugsAvailable;

public class HospitalHelper {
    public Hospital buildHospitalDetails(String userInput) {
        Hospital hospital = Hospital.builder().build();
        String[] userInputs = userInput.split(" ");
        if (userInputs.length > 0) {
            String[] stateInput = userInputs[0].split(",");
            List<Patient> patients = new ArrayList<>();

            for (String status : stateInput) {
                String healthState = getStateBySymbol(status);
                Patient patient = new Patient();
                patient.setHealthState(healthState);
                patients.add(patient);
            }
            hospital.setPatients(patients);

            List<Drug> drugs = new ArrayList<>();
            List<String> prescribedDrug = new ArrayList<>();
            if (areDrugsAvailable(userInputs)) {
                String[] drugInput = userInputs[1].split(",");
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
}
