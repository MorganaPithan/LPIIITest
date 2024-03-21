package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class IMCCalcTest {

    @Test
    void calcImc() {
        // altura 1,75 peso 70 = 22,857
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(1.75, 70);
        assertThat(result).isCloseTo(22.857f, Offset.offset(0.001f));
    }

    @Test
    void calcImc2() {
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(1.50, 65);
        assertThat(result).isCloseTo(28.888f, Offset.offset(0.001f));
    }

    @Test
    void calcImc3Erro() {
        IMCCalc imcCalc = new IMCCalc();
        var result = imcCalc.calcImc(1.65, 78);
        assertThat(result).isCloseTo(28.487f, Offset.offset(0.001f));
    }
}