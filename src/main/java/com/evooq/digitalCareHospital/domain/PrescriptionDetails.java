package com.evooq.digitalCareHospital.domain;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PrescriptionDetails {

    private Patient patient;
    private String prescribedMedicine = "";

    public PrescriptionDetails(List<String> drugs, Patient patientDetails) {
        StringBuilder builder = new StringBuilder();
        for (String arg : drugs) {
            builder.append(arg);
        }
        prescribedMedicine = builder.toString();
        patient = patientDetails;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionDetails that = (PrescriptionDetails) o;
        return Objects.equal(patient, that.patient) &&
                Objects.equal(prescribedMedicine, that.prescribedMedicine);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patient, prescribedMedicine);
    }
}
