package com.company.Design;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawGraphics extends JFrame {
    public DrawGraphics(ArrayList<Integer> Errors, String functionName){
        super("Graphic");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(850,265);
        setVisible(true);
        panel Panelka = new panel(Errors, functionName);
        add(Panelka);
        Panelka.paint(getGraphics());

    }
}

class panel extends JPanel{

    ArrayList<Integer> Errors;
    String functionName;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        g.drawString("3", 25, 50);
        g.drawString("2", 25, 100);
        g.drawString("1", 25, 150);
        g.drawString("0", 25, 200);
        g.drawString( functionName, 425,230);
        int x = 0;
        for (Integer i = 0; i < Errors.size()-1; ++i) {
            g.drawLine(x * 50+50, 250-(50 * Errors.get(i)+50), (x + 1) * 50+50, 250-(50 * Errors.get(i + 1)+50));
            g.drawString( i.toString() , 50+x*50,205);

            ++x;
        }
    }



    panel(ArrayList<Integer> Error, String functionName){
        setFunctionName(functionName);
        setErrors(Error);
    }

    public ArrayList<Integer> getErrors() {
        return Errors;
    }
    public void setErrors(ArrayList<Integer> errors) {
        Errors = errors;
    }

    public String getFunctionName() { return functionName; }
    public void setFunctionName(String functionName) { this.functionName = functionName;}
}

