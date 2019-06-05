package com.company.Boolean;

import java.util.ArrayList;

public class BooleanConvertions {
    public static ArrayList<Boolean> fromIntToBoolean(int n){
        ArrayList<Boolean> bits = new ArrayList<>(4);

        for(int i = 0; i < 4; i++){
            bits.add(false);
        }


        int index = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                bits.add(index,true);
            }
            else {
                bits.add(index, false);
            }
            ++index;
            n = n >>> 1;
        }
        return bits;
    };

    public static int fromBooleanToInt(Boolean b){
        return b ? 1 : 0;
    };

    public static void CompareTwoFunctions(ArrayList<Boolean> a1, ArrayList<Boolean> a2){
        int i = 0;
        if(a1.size()!=a2.size()){
            System.out.println("### vectors not equal");
        }
        else{
            for (int j = 0; j < a1.size(); j++) {

                boolean b;

                if(a1.get(j) == a2.get(j)){
                    b = true;
                }
                else {
                    i++;
                    b = false;
                }
                System.out.println(a1.get(j) + " | " + a2.get(j) + " | " + b);
            }
        }
        System.out.println("Error: " + i);
    };



}
