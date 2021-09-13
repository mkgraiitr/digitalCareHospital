package com.evooq.digitalCareHospital.engine;

import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.evooq.digitalCareHospital.domain.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmatureStrategy implements TreatmentStrategy {

    @Override
    public List<PrescriptionDetails> getPrescription(List<Patient> patients, List<String> drugs) {

        List<PrescriptionDetails> prescriptions = new ArrayList<>();
        for (int patientIndex = 0; patientIndex < patients.size(); patientIndex++) {
            if (patientIndex < drugs.size()) {
                prescriptions.add(new PrescriptionDetails(Arrays.asList(drugs.get(patientIndex)), patients.get(patientIndex)));
            } else {
                prescriptions.add(new PrescriptionDetails(new ArrayList<String>(), patients.get(patientIndex)));
            }
        }
        return prescriptions;
    }
}
