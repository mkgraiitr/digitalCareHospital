package com.evooq.digitalCareHospital.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacy {
    private List<Drug> drugs = new ArrayList<>();
}
