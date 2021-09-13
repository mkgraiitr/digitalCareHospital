package com.evooq.digitalCareHospital.domain;

import com.evooq.digitalCareHospital.service.DigitalDoctor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Hospital {
    private List<DigitalDoctor> doctors = new ArrayList<>();
    private Pharmacy pharmacy = new Pharmacy();
    private List<Patient> patients = new ArrayList<>();

    public List<String> getDrugList() {
        return pharmacy.getDrugs().stream().map(Drug::getName).collect(Collectors.toList());
    }
}
