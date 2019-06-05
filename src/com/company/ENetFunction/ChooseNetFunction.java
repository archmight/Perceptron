package com.company.ENetFunction;

public class ChooseNetFunction {

    private static ChooseNetFunction chooseNetFunction = new ChooseNetFunction();
    private ENetFunction netFunction;
    static double netValue;

    public static ChooseNetFunction init(){
        return chooseNetFunction;
    }

    public static ChooseNetFunction getInstance(double netvalue){
        netValue = netvalue;
        return chooseNetFunction;
    }

    public ENetFunction mainMethod(String nameNetFunction){

        switch (nameNetFunction){

            case "Threeshold" :
                this.netFunction = ENetFunction.ThreesholdF;
                break;

            case "Another" :
                this.netFunction = ENetFunction.SigmoidF;
                break;

            case "Tang" :
                this.netFunction = ENetFunction.TangF;
                break;

            case "Sigmoid" :
                this.netFunction = ENetFunction.AnotherF;
                break;

            default:
                System.out.println("###incorrect name of function");
                break;
        }
        return netFunction;
    }

    ENetFunction getNetFunction(){
        return netFunction;
    }

    private ChooseNetFunction(){

    }
}
