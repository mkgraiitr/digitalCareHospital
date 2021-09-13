package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.constants.PrescriptionGuide;
import com.evooq.digitalCareHospital.domain.Disease;
import com.evooq.digitalCareHospital.domain.DrugEffects;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.evooq.digitalCareHospital.constants.HealthState.getSymbolByState;
import static com.evooq.digitalCareHospital.util.HospitalUtil.isFlyingSpaghettiNoodlePowerEnabled;

public class PatientManager {
    public Map<String, Long> getPatientEndState(List<PrescriptionDetails> prescriptions) {

        return prescriptions.stream().map(prescription -> {
            DrugEffects drugEffects = PrescriptionGuide.getDrugEffects(prescription);
            if (drugEffects.getEndState().equalsIgnoreCase("Dead") && isFlyingSpaghettiNoodlePowerEnabled()) {
                drugEffects.setEndState("Healthy");
            }
            return getSymbolByState(drugEffects.getEndState());
        }).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public Patient createPatientRecord() {
        return new Patient();
    }

    public void assignDoctor(Disease disease) {
    }


}
