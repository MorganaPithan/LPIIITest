package org.example;

public class CurrencyConverter {
    public float dolarConverter(float dolar) {
        return (float) (dolar * 4.97);
    }

    public float euroConverter(float euro) {
        return (float) (euro * 5.43);
    }

    public float ieneConverter(float iene) {
        return (float) (iene * 0.033);
    }

    public float wonConverter(float won) {
        return (float) (won * 0.0037);
    }

    public float pesoConverter(float peso) {
        return (float) (peso * 0.0058);
    }
}
