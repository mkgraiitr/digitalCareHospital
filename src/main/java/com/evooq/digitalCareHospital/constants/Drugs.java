package com.evooq.digitalCareHospital.constants;

import java.util.stream.Stream;

public enum Drugs {
    ASPIRIN("As", "Aspirin"),
    ANTIBIOTIC("An", "Antibiotic"),
    INSULIN("I", "Insulin"),
    PARACETAMOL("P", "Paracetamol");

    private final String symbol;
    private final String drugName;

    Drugs(String symbol, String drugName) {
        this.symbol = symbol;
        this.drugName = drugName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDrugName() {
        return drugName;
    }

    public static String getDrugNameBySymbol(String symbol) {
        return Stream.of(Drugs.values())
                .filter(state -> state.symbol.equalsIgnoreCase(symbol))
                .findFirst().get().drugName;
    }
}
