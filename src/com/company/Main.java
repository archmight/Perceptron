package com.company;

import com.company.Design.DrawGraphics;
import com.company.ENetFunction.ChooseNetFunction;
import com.company.ENetFunction.ENetFunction;
import com.company.neural.Neuron;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {


        String functionName = "Threeshold";
        Neuron n = new Neuron(functionName);
        ArrayList<Integer> bruteforse = new ArrayList<>();
        n.epoch(bruteforse);

        DrawGraphics d = new DrawGraphics(n.ErrorList(), functionName);




    }
}
