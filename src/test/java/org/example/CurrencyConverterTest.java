package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyConverterTest {
    private CurrencyConverter currencyConverter;

    @BeforeEach
    void setUp() {
        currencyConverter = new CurrencyConverter();
    }

    @Test
    void dolarConverter() {
        var result = currencyConverter.dolarConverter(12);
        assertThat(result).isCloseTo(59.64f, Offset.offset(0.01f));
    }
    @Test
    void euroConverter() {
        var result = currencyConverter.euroConverter(17);
        assertThat(result).isCloseTo(92.31f, Offset.offset(0.01f));
    }
    @Test
    void ieneConverter() {
        var result = currencyConverter.ieneConverter(29);
        assertThat(result).isCloseTo(0.957f, Offset.offset(0.01f));
    }
    @Test
    void wonConverter() {
        var result = currencyConverter.wonConverter(1);
        assertThat(result).isCloseTo(0.0037f, Offset.offset(0.001f));
    }
    @Test
    void pesoConverter() {
        var result = currencyConverter.pesoConverter(55);
        assertThat(result).isCloseTo(0.319f, Offset.offset(0.01f));
    }
    @Test
    void pesoConverterError() {
        var result = currencyConverter.pesoConverter(55);
        assertThat(result).isCloseTo(0.374f, Offset.offset(0.01f));
    }
}