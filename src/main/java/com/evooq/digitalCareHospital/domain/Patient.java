package com.evooq.digitalCareHospital.domain;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    private String healthState;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                ", healthState='" + healthState + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equal(healthState, patient.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(healthState);
    }
}
