package com.company.neural;

import com.company.Boolean.BooleanConvertions;

public class InputSignal {

    private boolean boolean_input = false;
    private double weight = 0;

    public Boolean isBoolean_input() { return boolean_input; }
    public void setBoolean_input(Boolean boolean_input) { this.boolean_input = boolean_input; }
    public double getWeight() { return weight; }


    //FULL CORRECT, DON'T TOUCH
    private void increaseWeight(double deltaWeight) { this.weight = (double) Math.round((this.weight + deltaWeight)*100)/100; }
    public void changeWeight(double learningRate, double delta, double derived) {
        increaseWeight(learningRate*delta*derived* BooleanConvertions.fromBooleanToInt(boolean_input));
    }
}
