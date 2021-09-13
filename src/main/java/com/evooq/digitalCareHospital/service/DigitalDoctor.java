package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.evooq.digitalCareHospital.engine.TreatmentStrategy;

import java.util.List;

public class DigitalDoctor {
    private TreatmentStrategy treatmentStrategy;

    public List<PrescriptionDetails> getPrescription(List<Patient> patients, List<String> drugs) {
        return treatmentStrategy.getPrescription(patients, drugs);
    }

    public void setTreatmentStrategy(TreatmentStrategy treatmentStrategy) {
        this.treatmentStrategy = treatmentStrategy;
    }
}
