package com.evooq.digitalCareHospital.constants;

import com.evooq.digitalCareHospital.domain.DrugEffects;
import com.evooq.digitalCareHospital.domain.Patient;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Map;

public class PrescriptionGuide {

    private static Map<PrescriptionDetails, DrugEffects> prescriptions =
            ImmutableMap.<PrescriptionDetails, DrugEffects>builder()
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.ASPIRIN.getDrugName()), Patient.builder().healthState(HealthState.FEVER.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.HEALTHY.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.ANTIBIOTIC.getDrugName()), Patient.builder().healthState(HealthState.TUBERCULOSIS.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.HEALTHY.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.INSULIN.getDrugName()), Patient.builder().healthState(HealthState.DIABETES.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.DIABETES.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.INSULIN.getDrugName(), Drugs.ANTIBIOTIC.getDrugName()), Patient.builder().healthState(HealthState.HEALTHY.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.FEVER.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.ANTIBIOTIC.getDrugName(), Drugs.INSULIN.getDrugName()), Patient.builder().healthState(HealthState.HEALTHY.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.FEVER.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.PARACETAMOL.getDrugName()), Patient.builder().healthState(HealthState.FEVER.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.HEALTHY.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.PARACETAMOL.getDrugName(), Drugs.ASPIRIN.getDrugName()), Patient.builder().healthState(HealthState.HEALTHY.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.DEAD.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(Drugs.ASPIRIN.getDrugName(), Drugs.PARACETAMOL.getDrugName()), Patient.builder().healthState(HealthState.HEALTHY.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.DEAD.getState()).build())
                    .put(new PrescriptionDetails(Arrays.asList(""), Patient.builder().healthState(HealthState.DIABETES.getState()).build()),
                            DrugEffects.builder()
                                    .endState(HealthState.DEAD.getState()).build())
                    .build();

    public static DrugEffects getDrugEffects(PrescriptionDetails prescriptionDetails) {
        return prescriptions.getOrDefault(prescriptionDetails, DrugEffects.builder().endState(prescriptionDetails.getPatient().getHealthState()).build());

    }

}

