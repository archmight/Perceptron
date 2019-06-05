package com.company.neural;

import java.util.ArrayList;

public class Neuron {
    private Layer layer;
    ArrayList<Integer> Errors = new ArrayList<>();

    public ArrayList<Integer> ErrorList(){return Errors;}

    public void addError(int i){
        Errors.add(i);
    }
    public Neuron (String functionName) {
        layer = new Layer(functionName);
    }
    public void epoch(ArrayList<Integer> bruteforse){
        for(int i = 0 ;i < 16; ++i) {
            int error = layer.errorEpoch(bruteforse);
            addError(error);
        }
    }
}
