package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.constants.Drugs;
import com.evooq.digitalCareHospital.constants.PatientDischargeDetails;
import com.evooq.digitalCareHospital.domain.*;
import com.evooq.digitalCareHospital.engine.ImmatureStrategy;

import java.util.ArrayList;
import java.util.List;

import static com.evooq.digitalCareHospital.constants.HealthState.getStateBySymbol;
import static com.evooq.digitalCareHospital.util.CommandUtility.printEndResult;

public class HospitalManager {
    public void simulateHospital(String userInput) {
        HospitalManager hospitalManager = new HospitalManager();
        Hospital hospital = hospitalManager.buildHospitalDetails(userInput);
        //for simplicity only one doctor is being used
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0)
                .getPrescription(hospital.getPatients(), hospital.getDrugList());
        PatientManager patientManager = new PatientManager();
        printEndResult(patientManager.getPatientEndState(prescriptions));
    }

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

            List<DigitalDoctor> digitalDoctors = new ArrayList<>();
            DigitalDoctor doctor = new DigitalDoctor();
            ImmatureStrategy immatureStrategy = new ImmatureStrategy();
            doctor.setTreatmentStrategy(immatureStrategy);
            digitalDoctors.add(doctor);
            hospital.setDoctors(digitalDoctors);
        }
        return hospital;
    }

    public PatientDischargeDetails getDischargeDetails(Patient patient) {
        return PatientDischargeDetails.builder().build();
    }
}
