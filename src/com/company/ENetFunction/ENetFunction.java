package com.company.ENetFunction;

import static java.lang.Math.abs;
import static java.lang.Math.tanh;

public enum ENetFunction {
    ThreesholdF(0) {
        @Override
        public double functionActivation(double net) {
            return (net>= 0) ? 1 : 0;
        }
        @Override
        public double functionActivationDerived(double net){
            return 1;
        }
    },

    SigmoidF(1){
        @Override
        public double functionActivation(double net){
            return 1/(1+Math.exp(-net));
        }
        @Override
        public double functionActivationDerived(double net) {
            return super.functionActivationDerived(net*(1-net));
        }
    },

    // (1/2)*(tanh(x)+1)
    TangF(2){
        @Override
        public double functionActivation(double net){
            return super.functionActivationDerived((0.5)*(tanh(net)+1));
        }
        @Override
        public double functionActivationDerived(double net) {
            return 0.5*Math.pow(Math.cosh(net),2);
        }
    },

    AnotherF(3){
        @Override
        public double functionActivation(double net){
            return 0.5*(net/(1+abs(net))+1);
        }
        @Override
        public double functionActivationDerived(double net) {
            return super.functionActivationDerived(0.5*Math.pow(abs(net)+1,2));
        }
    };

    private int i;
    public double functionActivation(double net){return net;}
    public double functionActivationDerived(double net){
        return net;
    }



    ENetFunction(int i){
        this.i = 2;
    }

}

