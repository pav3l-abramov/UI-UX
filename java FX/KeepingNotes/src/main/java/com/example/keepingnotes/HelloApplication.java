package com.example.keepingnotes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane splitter = new GridPane();
        TextArea textAreaMain = new TextArea("№--category--title--link");
        TextArea textAreaLink = new TextArea();
        TextArea textAreaTitle = new TextArea();
        AtomicReference<Integer> i= new AtomicReference<>(1);
        StringBuilder text= new StringBuilder();
        textAreaLink.setPrefHeight(15);
        textAreaLink.setPrefWidth(265);
        textAreaTitle.setPrefHeight(15);
        textAreaTitle.setPrefWidth(264);
        textAreaMain.setEditable(false);


        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label0 = new Label();
        label1.setText("link:");
        label2.setText("title:");
        label3.setText("sort:");
        label0.setText("Notes:");

        ChoiceBox choiceBox=new ChoiceBox();
        choiceBox.getItems().add("work");
        choiceBox.getItems().add("study");
        choiceBox.getItems().add("fun");
        choiceBox.getItems().add("game");
        choiceBox.getItems().add("goods");
        choiceBox.getItems().add("other");
        choiceBox.setValue("work");

        ChoiceBox sortBox=new ChoiceBox();
        sortBox.getItems().add("all");
        sortBox.getItems().add("work");
        sortBox.getItems().add("study");
        sortBox.getItems().add("fun");
        sortBox.getItems().add("game");
        sortBox.getItems().add("goods");
        sortBox.getItems().add("other");
        sortBox.setValue("all");

        Button addNew = new Button("add");addNew.setOnAction( event -> {text.append("\n"+"NewString"+i.get()+"--"+choiceBox.getValue()+"--"+textAreaTitle.getText()+"--"+textAreaLink.getText());textAreaMain.appendText("\n"+i+"--"+choiceBox.getValue()+"--"+textAreaTitle.getText()+"--"+textAreaLink.getText()) ;i.getAndSet(i.get() + 1);});
        Button sort = new Button("sort");sort.setOnAction( event -> {textAreaMain.setText("№--category--title--link");textAreaMain.appendText("\n"+sortir(sortBox.getValue().toString(),text.toString()));});
        Button clear = new Button("clear");clear.setOnAction( event ->{text.setLength(0);textAreaMain.setText("№--category--title--link");i.set(1);});

        HBox Line1 = new HBox(label1,textAreaLink);
        HBox Line2 = new HBox(label2,textAreaTitle);
        splitter.add(choiceBox, 0, 0, 1, 1);
        splitter.add(addNew, 1, 0, 1, 1);
        splitter.add(Line1, 0, 1, 2, 1);
        splitter.add(Line2, 0, 2, 2, 1);
        splitter.add(label0, 0, 3, 1, 1);
        splitter.add(textAreaMain, 0, 4, 2, 1);
        splitter.add(label3, 0, 5, 1, 1);
        splitter.add(sortBox, 0, 6, 1, 1);
        splitter.add(sort, 1, 6, 1, 1);
        splitter.add(clear, 0, 7, 1, 1);
        startScene(stage, splitter);
    }
    private void startScene(Stage stage, Pane pane) {
        Scene scene = new Scene(pane, 400, 300, Color.KHAKI);
        stage.setTitle("Keeping Notes");
        stage.setMinHeight(400);
        stage.setMinWidth(300);
        stage.setMaxHeight(400);
        stage.setMaxWidth(300);
        stage.setScene(scene);
        stage.show();
    }

    private String sortir (String sort,String text) {
        StringBuilder sortText= new StringBuilder();
        String[] input = text.toString().split("NewString");
        for (var i=1; i<Integer.valueOf(input.length) ;i++) {
            String[] inputlitle=input[i].toString().split("--");
            if (Objects.equals(inputlitle[1], sort) &&i>0){sortText.append(input[i]);}
            if (sort=="all"&&i>0){sortText.append(input[i]);}
            System.out.println(inputlitle[1]);
            System.out.println(sort);
        }
        return sortText.toString();
    }
    public static void main(String[] args) {
        launch();
    }

}