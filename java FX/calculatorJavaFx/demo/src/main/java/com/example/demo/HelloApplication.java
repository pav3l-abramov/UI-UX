package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    private static class Clc {
        private final List<Button> buttons = new ArrayList<>();

        void addButton(Button... button) {
            buttons.addAll(List.of(button));
        }


        void setBtnMaxSize() {
            for (Button b : buttons) {
                b.setPrefWidth(Integer.MAX_VALUE);
                b.setPrefHeight(Integer.MAX_VALUE);
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane splitter = new GridPane();
        GridPane digs = new GridPane();
        AtomicReference<String> r= new AtomicReference<>("");
        TextArea textArea = new TextArea("0");
        StringBuilder  text =new StringBuilder ("");
        textArea.setStyle( "-fx-font-size: 23" );
        textArea.setEditable(false);
        textArea.lengthProperty();
        StackPane.setMargin(textArea, new Insets(20, 0, 30, 50));

        Clc clc = new Clc();

        Button bt0 = new Button("0");bt0.setOnAction( event -> {text.append("0");textArea.setText(text.toString());});
        Button bt1 = new Button("1");bt1.setOnAction( event -> {text.append("1");textArea.setText(text.toString());});
        Button bt2 = new Button("2");bt2.setOnAction( event -> {text.append("2");textArea.setText(text.toString());});
        Button bt3 = new Button("3");bt3.setOnAction( event -> {text.append("3");textArea.setText(text.toString());});
        Button bt4 = new Button("4");bt4.setOnAction( event -> {text.append("4");textArea.setText(text.toString());});
        Button bt5 = new Button("5");bt5.setOnAction( event -> {text.append("5");textArea.setText(text.toString());});
        Button bt6 = new Button("6");bt6.setOnAction( event -> {text.append("6");textArea.setText(text.toString());});
        Button bt7 = new Button("7");bt7.setOnAction( event -> {text.append("7");textArea.setText(text.toString());});
        Button bt8 = new Button("8");bt8.setOnAction( event -> {text.append("8");textArea.setText(text.toString());});
        Button bt9 = new Button("9");bt9.setOnAction( event -> {text.append("9");textArea.setText(text.toString());});
        Button bt_del = new Button("/");bt_del.setOnAction( event -> {text.append("/");textArea.setText(text.toString());});
        Button bt_proc = new Button("%");bt_proc.setOnAction( event -> {textArea.setText(Double.toString(Float.parseFloat(text.toString())*100)+"%");text.setLength(0);});
        Button bt_CE = new Button("CE");bt_CE.setOnAction( event -> {text.setLength(0);textArea.setText("0");});
        Button bt_C = new Button("C");bt_C.setOnAction( event -> {text.setLength(0);textArea.setText("0");});
        Button bt_delet = new Button("del");bt_delet.setOnAction( event -> {text.setLength(0);textArea.setText(text.toString());});
        Button bt_inverse = new Button("1/x");bt_inverse.setOnAction( event -> {textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),-1)));text.setLength(0);});
        Button bt_square = new Button("x²");bt_square.setOnAction( event -> {textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),2)));text.setLength(0);});
        Button bt_root = new Button("√x");bt_root.setOnAction( event -> {textArea.setText(Double.toString(Math.pow(Float.parseFloat(text.toString()),0.5)));text.setLength(0);});
        Button bt_multi = new Button("*");bt_multi.setOnAction( event -> {text.append("*");textArea.setText(text.toString());});
        Button bt_minus = new Button("-");bt_minus.setOnAction( event -> {text.append("-");textArea.setText(text.toString());});
        Button bt_plus = new Button("+");bt_plus.setOnAction( event -> {text.append("+");textArea.setText(text.toString());});
        Button bt_ravno = new Button("=");bt_ravno.setOnAction( event -> {textArea.setText(compute(text));text.setLength(0);});
        Button bt_zap = new Button(",");bt_zap.setOnAction( event -> {text.append(".");textArea.setText(text.toString());});
        Button bt_minplus = new Button("+/-");bt_minplus.setOnAction( event -> {r.set(plusmin(text));textArea.setText(plusmin(text));text.setLength(0);text.append(r);});
        bt0.setStyle( "-fx-font-size: 23" );
        bt1.setStyle( "-fx-font-size: 23" );
        bt2.setStyle( "-fx-font-size: 23" );
        bt3.setStyle( "-fx-font-size: 23" );
        bt4.setStyle( "-fx-font-size: 23" );
        bt5.setStyle( "-fx-font-size: 23" );
        bt6.setStyle( "-fx-font-size: 23" );
        bt7.setStyle( "-fx-font-size: 23" );
        bt8.setStyle( "-fx-font-size: 23" );
        bt9.setStyle( "-fx-font-size: 23" );
        bt_del.setStyle( "-fx-font-size: 23" );
        bt_proc.setStyle( "-fx-font-size: 23" );
        bt_CE.setStyle( "-fx-font-size: 23" );
        bt_C.setStyle( "-fx-font-size: 23" );
        bt_delet.setStyle( "-fx-font-size: 23" );
        bt_inverse.setStyle( "-fx-font-size: 23" );
        bt_square.setStyle( "-fx-font-size: 23" );
        bt_root.setStyle( "-fx-font-size: 23" );
        bt_multi.setStyle( "-fx-font-size: 23" );
        bt_minus.setStyle( "-fx-font-size: 23" );
        bt_plus.setStyle( "-fx-font-size: 23" );
        bt_ravno.setStyle( "-fx-font-size: 23" );
        bt_zap.setStyle( "-fx-font-size: 23" );
        bt_minplus.setStyle( "-fx-font-size: 23" );


        clc.addButton(bt_proc, bt_CE, bt_C, bt_delet,bt_inverse, bt_square, bt_root, bt_del,bt7, bt8, bt9, bt_multi,bt4, bt5, bt6, bt_minus,bt1, bt2, bt3, bt_plus,bt_minplus, bt0, bt_zap, bt_ravno);
        clc.setBtnMaxSize();

        splitter.add(textArea, 0, 0, 1, 1);
        splitter.add(digs, 0, 1, 1, 1);

        digs.add(bt_proc, 0, 0);
        digs.add(bt_CE, 1, 0);
        digs.add(bt_C, 2, 0);
        digs.add(bt_delet, 3, 0);
        digs.add(bt_inverse, 0, 1);
        digs.add(bt_square, 1, 1);
        digs.add(bt_root, 2, 1);
        digs.add(bt_del, 3, 1);

        digs.add(bt7, 0, 2);
        digs.add(bt8, 1, 2);
        digs.add(bt9, 2, 2);
        digs.add(bt_multi, 3, 2);
        digs.add(bt4, 0, 3);
        digs.add(bt5, 1, 3);
        digs.add(bt6, 2, 3);
        digs.add(bt_minus, 3, 3);

        digs.add(bt1, 0, 4);
        digs.add(bt2, 1, 4);
        digs.add(bt3, 2, 4);
        digs.add(bt_plus, 3, 4);
        digs.add(bt_minplus, 0, 5);
        digs.add(bt0, 1, 5);
        digs.add(bt_zap, 2, 5);
        digs.add(bt_ravno, 3, 5);


        startScene(stage, splitter);
    }
    public static boolean isNumeric(String str) {
        switch (str) {
            case ".":
                return true;}
        try {Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }

    }
    private String plusmin(StringBuilder display) {
        if (display.length() == 0) return null;
        String text="";
        String[] input = display.toString().split("(?<=\\G.)");
        switch (input[0]) {
            case "+":
                input[0]="-";
                break;
            case"-":
                input[0]="+";
                break;
        }
        for (int i=0; i<display.length() ;i++) {
            text+=input[i];
        }
        return text;
    }
    private String compute(StringBuilder display) {
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
    private void startScene(Stage stage, Pane pane) {
        Scene scene = new Scene(pane, 300, 400, Color.KHAKI);
        stage.setTitle("Calculator");
        stage.setMinHeight(400);
        stage.setMinWidth(300);
        stage.setScene(scene);
        stage.show();
    }
}