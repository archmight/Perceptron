package com.company.neural;

import com.company.Boolean.BooleanConvertions;
import com.company.Boolean.BooleanFunction;
import com.company.ENetFunction.ChooseNetFunction;
import com.company.ENetFunction.ENetFunction;

import java.util.ArrayList;

import static com.company.Boolean.BooleanConvertions.fromIntToBoolean;

public class Layer {

    ChooseNetFunction chooseNetFunction;
    ENetFunction netFunction;
    double LearningRate = 0.3;
    InputSignal extraInputSignal;
    ArrayList<InputSignal> inputSignals;
    double net;


    public double sumFunction() {
        double sum = 0;
        sum += extraInputSignal.getWeight()* BooleanConvertions.fromBooleanToInt(extraInputSignal.isBoolean_input());
        for(int i = 0; i < (inputSignals.size()); ++i){                             ///////
            sum += inputSignals.get(i).getWeight()*BooleanConvertions.fromBooleanToInt(inputSignals.get(i).isBoolean_input());
        }
        net = sum;
        return sum;
    }


    public double activation_function() {
        if(netFunction.functionActivation(sumFunction())>=0.5){
            return 1;
        }
        else {
            return 0;
        }
    }


    public byte tFunction(int elementOfBooleanFunction){
        if(BooleanFunction.getInstance().getBS_BooleanFunction().get(elementOfBooleanFunction)){
            return 1;
        }
        else {
            return 0;
        }
    }


    public double delta(int numberOfelementBooleanFunction){
        return tFunction(numberOfelementBooleanFunction) - activation_function();
    }


    public int errorEpoch(ArrayList<Integer> bruteforse){

        int errorCounter = 0;

        ArrayList<Boolean> aaaa = new ArrayList<>();
        for(int i = 0; i < 16; ++i){

            if(bruteforse == null){

            }
            else {

            }
            //init step input boolean values
            ArrayList<Boolean> inputSignalsStatement = fromIntToBoolean(i);
            for(int j = 0; j < 4; ++j) {
                inputSignals.get(j).setBoolean_input(inputSignalsStatement.get(j));
            }

            double a = delta(i);
            if(a == 0){
                aaaa.add(BooleanFunction.getInstance().getBS_BooleanFunction().get(i));
                continue;
            }
            else {
                aaaa.add(!BooleanFunction.getInstance().getBS_BooleanFunction().get(i));
            }

//            System.out.println("$$$$$ net value: " + net);
            ++errorCounter;
            extraInputSignal.changeWeight(LearningRate,a,netFunction.functionActivationDerived(net));
            for(int k = 0; k < 4; ++k ){
                inputSignals.get(k).changeWeight(LearningRate,a,netFunction.functionActivationDerived(net));
            }

        }

        System.out.println("********************************");
        for(int i = 0; i < 16; ++i){
            if(i != 15){
                if(aaaa.get(i))
                    System.out.print("1");
                else {
                    System.out.print("0");
                }
                System.out.print(",");
            }
            else{
                if(aaaa.get(i))
                    System.out.println("1");
                else {
                    System.out.println("0");
                }
            }


        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("error: " + errorCounter);
//        System.out.println("new exweight: " + extraInputSignal.getWeight() +"; exboolean: "+ extraInputSignal.isBoolean_input()+";" );
        System.out.print(extraInputSignal.getWeight() + ";"); //

        for (int h = 0; h < 4; h++){
//            System.out.println("X"+(4-h)+" - new weight: " + inputSignals.get(h).getWeight() +"; boolean: "+ inputSignals.get(h).isBoolean_input()+";" );
            System.out.print(inputSignals.get(3-h).getWeight() +";");
        }
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        return errorCounter;
    }



    Layer(String functionName){
        chooseNetFunction = ChooseNetFunction.init();
        netFunction = chooseNetFunction.mainMethod(functionName);
        extraInputSignal = new InputSignal();
        inputSignals = new ArrayList<InputSignal>(4);
        for (int i = 0; i < 4; i++) {
            inputSignals.add(new InputSignal());
        }
        extraInputSignal.setBoolean_input(true);
    }
}
