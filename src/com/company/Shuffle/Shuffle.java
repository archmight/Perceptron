package com.company.Shuffle;

import java.util.ArrayList;
import java.util.Collections;

public class Shuffle {

    public static ArrayList<Integer> generator(int range, int numbers){
    ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<range; i++) {
            list.add(new Integer(i));
        }
        Collections.sort(list);
        Collections.shuffle(list);
        return list;
    }
}
