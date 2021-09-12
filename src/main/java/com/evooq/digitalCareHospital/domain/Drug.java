package com.evooq.digitalCareHospital.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Drug {
    private String name;
    private double quantity;
    private int frequency;
}
