package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.constants.PrescriptionDetails;
import com.evooq.digitalCareHospital.constants.PrescriptionGuide;
import com.evooq.digitalCareHospital.domain.Disease;
import com.evooq.digitalCareHospital.domain.DrugEffects;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.engine.ImmatureStrategy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.evooq.digitalCareHospital.constants.HealthState.getSymbolByState;

public class PatientManager {

    public Map<String, Long> getPatientEndState(List<Patient> patients, List<String> drugs) {
        System.out.println("Applying simple strategy");
        ImmatureStrategy immatureStrategy = new ImmatureStrategy();
        List<PrescriptionDetails> prescriptionDetails = immatureStrategy.getPrescription(patients, drugs);
        return prescriptionDetails.stream().map(prescription -> {
            DrugEffects drugEffects = PrescriptionGuide.getDrugEffects(prescription);
            return getSymbolByState(drugEffects.getEndState());
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public Patient createPatientRecord() {
        return new Patient();
    }

    public void assignDoctor(Disease disease) {
    }


}
