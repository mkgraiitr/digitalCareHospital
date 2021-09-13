package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;

import java.util.ArrayList;
import java.util.List;

public class HospitalTestUtil {

    public static List<Patient> getPatientList(){
        List< Patient > patients = new ArrayList<>();
        patients.add(Patient.builder().healthState("Fever").build());
        patients.add(Patient.builder().healthState("Fever").build());
        patients.add(Patient.builder().healthState("Fever").build());
        return patients;
    }
    public static List<String> getDrugList(){
        List<String> drugs = new ArrayList<>();
        drugs.add("Paracetamol");
        drugs.add("Paracetamol");
        drugs.add("Paracetamol");
        return drugs;
    }

    public static List<Patient> getPatientListWithDiabetes(){
        List< Patient > patients = new ArrayList<>();
        patients.add(Patient.builder().healthState("Diabetes").build());
        patients.add(Patient.builder().healthState("Diabetes").build());
        patients.add(Patient.builder().healthState("Diabetes").build());
        return patients;
    }
    public static List<String> getInsulin(){
        List<String> drugs = new ArrayList<>();
        drugs.add("Insulin");
        drugs.add("Insulin");
        drugs.add("Insulin");
        return drugs;
    }

    public static List<Patient> getPatientListWithMixedDiseases(){
        List< Patient > patients = new ArrayList<>();
        patients.add(Patient.builder().healthState("Diabetes").build());
        patients.add(Patient.builder().healthState("Fever").build());
        patients.add(Patient.builder().healthState("Tuberculosis").build());
        return patients;
    }
    public static List<String> getMixedDoses(){
        List<String> drugs = new ArrayList<>();
        drugs.add("Insulin");
        drugs.add("Aspirin");
        drugs.add("Antibiotic");
        return drugs;
    }

}
