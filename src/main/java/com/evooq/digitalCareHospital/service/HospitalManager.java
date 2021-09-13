package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.evooq.digitalCareHospital.engine.TreatmentImplementation;
import com.evooq.digitalCareHospital.util.HospitalHelper;

import java.util.List;

import static com.evooq.digitalCareHospital.util.CommandUtility.printEndResult;

public class HospitalManager {
    public void simulateHospital(String userInput) {
        HospitalHelper hospitalHelper = new HospitalHelper();
        Hospital hospital = hospitalHelper.buildHospitalDetails(userInput);
        List<PrescriptionDetails> prescriptions = getPrescription(hospital.getPatients(), hospital.getDrugList());
        PatientManager patientManager = new PatientManager();
        printEndResult(patientManager.getPatientEndState(prescriptions));
    }

    public List<PrescriptionDetails> getPrescription(List<Patient> patients, List<String> drugs) {
        TreatmentImplementation treatmentImplementation = new TreatmentImplementation();
        return treatmentImplementation.getPrescription(patients, drugs);
    }

}
