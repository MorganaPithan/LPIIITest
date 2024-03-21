package org.example;

import java.sql.SQLOutput;

public class IMCCalc {
    public float calcImc(double height, float weight) {
        float result = (float) (weight / Math.pow(height, 2));
        if (result < 18.5){
            System.out.println("Underweight");
        } else if (result >= 18.5 && result <= 24.9){
            System.out.println("Normal weight");
        }
        else if (result >= 25 && result <= 29.9){
            System.out.println("Overweight");
        }
        else if (result >= 30 && result <= 39.9){
            System.out.println("Obesity");
        }else {
            System.out.println("Severe obesity");
        }
        return result;

    }
}
