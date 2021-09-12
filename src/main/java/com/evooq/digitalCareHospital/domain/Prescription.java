package com.evooq.digitalCareHospital.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    private Doctor doctor = new Doctor();
    private Patient patient = new Patient();
    private List<Drug> drugs = new ArrayList<>();
}
