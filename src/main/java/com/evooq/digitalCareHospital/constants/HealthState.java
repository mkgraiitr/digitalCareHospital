package com.evooq.digitalCareHospital.constants;

import java.util.stream.Stream;

public enum HealthState {
    FEVER("F", "Fever"),
    HEALTHY("H", "Healthy"),
    DIABETES("D", "Diabetes"),
    TUBERCULOSIS("T", "Tuberculosis"),
    DEAD("X", "Dead");

    private final String symbol;
    private final String state;

    HealthState(String symbol, String state) {
        this.symbol = symbol;
        this.state = state;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getState() {
        return state;
    }

    public static String getStateBySymbol(String symbol) {
        return Stream.of(HealthState.values())
                .filter(state -> state.symbol.equalsIgnoreCase(symbol))
                .findFirst().get().state;
    }

    public static String getSymbolByState(String state) {
        return Stream.of(HealthState.values())
                .filter(healthState -> healthState.state.equalsIgnoreCase(state))
                .findFirst().get().symbol;
    }

}



