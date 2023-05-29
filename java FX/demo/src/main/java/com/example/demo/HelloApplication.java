package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextArea textAreaMain = new TextArea("          Keeping notes");
        TextArea textAreaLink = new TextArea();
        TextArea textAreaTitle = new TextArea();
        AtomicReference<Integer> i= new AtomicReference<>(1);
        StringBuilder text= new StringBuilder();
        StringBuilder textSort= new StringBuilder();
        textAreaLink.setPrefHeight(20);
        textAreaLink.setPrefWidth(220);
        textAreaTitle.setPrefHeight(20);
        textAreaTitle.setPrefWidth(220);
        textAreaMain.setPrefWidth(360);
        textAreaMain.setPrefHeight(440);
        textAreaMain.setEditable(false);
        textAreaTitle.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 7 ? change : null));

        Label label1 = new Label();
        Label label2 = new Label();

        label1.setText("Link:");
        label2.setText("Title:");


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

        choiceBox.prefWidth(85);
        sortBox.prefWidth(85);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        Button addNew = new Button("ADD");addNew.setOnAction(event -> {text.append("\n"+"NewString"+i.get()+"\t"+choiceBox.getValue()+"\t"+textAreaTitle.getText()+"\t"+textAreaLink.getText());textSort.append("\n"+"№ "+i.get()+" "+choiceBox.getValue()+"\t"+textAreaTitle.getText()+"\t"+textAreaLink.getText());textAreaMain.appendText("\n"+i+" "+choiceBox.getValue()+"\t"+textAreaTitle.getText()+"\t"+textAreaLink.getText()) ;i.getAndSet(i.get() + 1);});
        Button sort = new Button("SORT");sort.setOnAction( event -> {textAreaMain.setText("          Keeping notes");textAreaMain.appendText("\n"+sortir(sortBox.getValue().toString(),text.toString(),textSort.toString()));});
        Button save = new Button("SAVE");save.setOnAction( event ->{
            File dest = fileChooser.showSaveDialog(stage);
            if (dest != null) {
                saveTextToFile(textSort.toString(), dest);
            }


        });

        addNew.prefWidth(320);
        sort.prefWidth(320);


        HBox hline1Tab1= new HBox(label1,textAreaLink);
        HBox hline2Tab1= new HBox(label2,textAreaTitle);
        HBox hline3Tab1= new HBox(new Label("Choose category:"),choiceBox);
        VBox vlineTab1 = new VBox (hline1Tab1,hline2Tab1,hline3Tab1,addNew);
        vlineTab1.setAlignment(Pos.valueOf("BASELINE_LEFT"));
        hline1Tab1.setAlignment(Pos.valueOf("CENTER"));
        hline2Tab1.setAlignment(Pos.valueOf("CENTER"));
        hline3Tab1.setAlignment(Pos.valueOf("CENTER"));
        hline1Tab1.setSpacing(20);
        hline2Tab1.setSpacing(20);
        hline3Tab1.setSpacing(20);
        vlineTab1.setSpacing(20);
        vlineTab1.setPadding(new Insets(20,0,0,0));

        HBox hline1Tab2= new HBox(new Label("Choose category:"),sortBox);
        VBox vlineTab2 = new VBox (hline1Tab2,sort);
        vlineTab2.setSpacing(20);
        hline1Tab2.setSpacing(20);
        vlineTab2.setPadding(new Insets(20,0,0,0));
        vlineTab2.setAlignment(Pos.valueOf("BASELINE_LEFT"));
        hline1Tab2.setAlignment(Pos.valueOf("CENTER"));

        VBox vlineTab3 = new VBox (save);
        vlineTab3.setSpacing(20);
        vlineTab3.setPadding(new Insets(20,0,0,0));
        vlineTab3.setAlignment(Pos.valueOf("BASELINE_LEFT"));

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("ADD", vlineTab1);
        Tab tab2 = new Tab("SORT"  ,vlineTab2 );
        Tab tab3 = new Tab("SAVE" , vlineTab3);

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);

        tabPane.setPadding(new Insets(0,20,20,20));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.valueOf("UNAVAILABLE"));

        HBox mainLine=new HBox(tabPane,textAreaMain);
        startScene(stage, mainLine);

    }
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException iex){
            System.out.println("not found");
        }
    }
    private String sortir (String sort,String text, String finalText) {
        StringBuilder sortText= new StringBuilder();
        String[] input = text.toString().split("NewString");
        String[] inputFin = finalText.toString().split("№ ");

        for (var i=1; i<Integer.valueOf(input.length) ;i++) {
            String[] inputlitle=input[i].toString().split("\t");
            if (Objects.equals(inputlitle[1], sort) &&i>0){sortText.append(inputFin[i]);}
            if (sort=="all"&&i>0){sortText.append(inputFin[i]);}
        }

        return sortText.toString();
    }


    private void startScene(Stage stage, Pane pane) {
        Scene scene = new Scene(pane, 720, 440);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Keeping notes");
        stage.setMinHeight(440);
        stage.setMinWidth(720);
        stage.setMaxHeight(440);
        stage.setMaxWidth(720);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
