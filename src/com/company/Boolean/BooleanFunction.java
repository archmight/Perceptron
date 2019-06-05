package com.company.Boolean;

import java.util.ArrayList;
import static jdk.nashorn.internal.runtime.JSType.toBoolean;

/* X1∨¬X2∨¬(X3∨X4) */
/* 1111 1000 1111 1111 */

// singleton
public class BooleanFunction {

    static BooleanFunction bf = new BooleanFunction();

    private ArrayList<Boolean> BS_BooleanFunction = new ArrayList<>();

    private BooleanFunction() {
        setBooleanFunction();
    }

    public static BooleanFunction getInstance() {
        return bf;
    }

    public  ArrayList<Boolean> getBS_BooleanFunction() {
        return BS_BooleanFunction;
    }

    private void setBooleanFunction() {

        for(int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j ){
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        if(toBoolean(i) || !toBoolean(j) || !(toBoolean(toBoolean(k)||toBoolean(l)))) {
                            BS_BooleanFunction.add(true);
                        }
                        else {
                            BS_BooleanFunction.add(false);
                        }
                    }
                }
            }
        }
    }

}
