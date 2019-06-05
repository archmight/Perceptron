package com.company.Binom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Combination {

    int N;
    int K;
    public static ArrayList<Boolean> numbers = new ArrayList<>(16);
    public static ArrayList<Integer> positions = new ArrayList<>(4);


    public static ArrayList<Boolean> getNumbers() {
        ArrayList<Boolean> tmp = numbers;



        return tmp;
    }

    private void step(int last_position){




        int i = last_position;

        while(true){
            if(!numbers.get(last_position)) {
                --last_position;
            }
            else {
                break;
            }
        }

        if(last_position == 0){
            return;
        }

        if(i == last_position){
            --last_position;
            step(last_position);
        }




    }


    public Combination(int n, int k){
        this.N = 16;
        this.K = k;
        Collections.fill(numbers,false);
        for(int i = 0 ; i < k; ++k) {
            positions.set(i,i);
            numbers.set(i,true);
        }
    }
}
