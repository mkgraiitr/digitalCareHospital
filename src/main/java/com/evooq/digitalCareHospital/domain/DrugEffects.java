package com.evooq.digitalCareHospital.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DrugEffects {
    private String endState;
    private List<String> sideEffects = new ArrayList<>();
}
