package com.example.calculatorfxml;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HelloController {
      @FXML
    private TextArea textArea;


    private StringBuilder text = new StringBuilder("");
    private AtomicReference<String> r= new AtomicReference<>("");
    @FXML
    protected void but0(ActionEvent event) {
        text.append("0");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but1(ActionEvent event) {
        text.append("1");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but2(ActionEvent event) {
        text.append("2");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but3(ActionEvent event) {
        text.append("3");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but4(ActionEvent event) {
        text.append("4");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but5(ActionEvent event) {
        text.append("5");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but6(ActionEvent event) {
        text.append("6");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but7(ActionEvent event) {
        text.append("7");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but8(ActionEvent event) {
        text.append("8");
        textArea.setText(text.toString());
    }
    @FXML
    protected void but9(ActionEvent event) {
        text.append("9");
        textArea.setText(text.toString());
    }
    @FXML
    protected void butminus(ActionEvent event) {
        text.append("-");
        textArea.setText(text.toString());
    }
    @FXML
    protected void butdel(ActionEvent event) {
        text.append("/");
        textArea.setText(text.toString());
    }
    @FXML
    protected void butplus(ActionEvent event) {
        text.append("+");
        textArea.setText(text.toString());
    }
    @FXML
    protected void butmulti(ActionEvent event) {
        text.append("*");
        textArea.setText(text.toString());
    }
    @FXML
    protected void butzap(ActionEvent event) {
        text.append(".");
        textArea.setText(text.toString());
    }
    @FXML
     void proc() {
        textArea.setText(Double.toString(Float.parseFloat(text.toString())*100)+"%");text.setLength(0);
    }
    @FXML
     void del() {
        text.setLength(0);
        textArea.setText(text.toString());
    }
    @FXML
    protected void roo(ActionEvent event) {
        textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),0.5)));text.setLength(0);
    }
    @FXML
    protected void squar(ActionEvent event) {
        textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),2)));text.setLength(0);
    }
    @FXML
    protected void invers(ActionEvent event) {
        textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),-1)));text.setLength(0);
    }

    @FXML
    protected void minplus() {
        r.set(plusmin(text));textArea.setText(plusmin(text));text.setLength(0);text.append(r);

    }
    protected String plusmin (StringBuilder display ){
        if (display.length() == 0) return null;
        String text = "";
        String[] input = display.toString().split("(?<=\\G.)");
        switch (input[0]) {
            case "+":
                input[0] = "-";
                break;
            case "-":
                input[0] = "+";
                break;
        }
        for (int i = 0; i < display.length(); i++) {
            text += input[i];
        }
        return text;}

    @FXML
    protected void compute() {
        textArea.setText(comput(text));text.setLength(0);
        }
    private String comput(StringBuilder display) {
        if (display.length()==0) return null;
        var flag=false;
        String[] input = display.toString().split("(?<=\\G.)");
        var currentNum = "";
        var res = 0.0;
        var restext="";
        List <Float> nums = new ArrayList();
        List <String> operations = new ArrayList();
        switch (input[0]) {
            case "-":
                flag=true;
                break;}
        if (!isNumeric(input[0]))input[0]="0";
        for (int i=0; i<display.length() ;i++) {
            if (isNumeric(input[i])||input[i]==".") {
                currentNum += input[i];
            } else {
                nums.add(Float.parseFloat(currentNum));
                currentNum = "";
                operations.add(input[i]);
            }
        }
        nums.add(Float.parseFloat(currentNum));
        if (flag){
            res = -nums.get(0);
        }
        else {
            res = nums.get(0);
        }

        for (var i=0; i<operations.size() ;i++) {

            var num=nums.get(i+1);
            switch (operations.get(i)){
                case "+":
                    res += num;
                    break;
                case "-":
                    res -= num;
                    break;
                case "*":
                    res *= num;
                    break;
                case "/":
                    if (num == 0.0) {
                        restext="division by zero";
                        return restext;
                    }
                    res /= num;
                    break;
            }

        }
        restext=Double.toString(res);
        return restext;
    }

    public static boolean isNumeric(String str) {
        switch (str) {
            case ".":
                return true;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
