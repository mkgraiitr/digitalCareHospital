package com.evooq.digitalCareHospital.engine;

import com.evooq.digitalCareHospital.constants.PrescriptionDetails;
import com.evooq.digitalCareHospital.domain.Patient;

import java.util.List;

public interface TreatmentStrategy {
    List<PrescriptionDetails> getPrescription(List<Patient> patients, List<String> drugs);
}
