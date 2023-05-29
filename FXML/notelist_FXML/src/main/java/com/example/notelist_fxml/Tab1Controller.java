package com.example.notelist_fxml;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;




public class Tab1Controller {
    @FXML
    private ChoiceBox<String> ChoiceBox ;
    @FXML
    public TextArea textLink ;
    public String allText;


    @FXML
    private  void add() {
        try {

            FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent first = firstLoader.load();
            HelloController helloController = firstLoader.getController();

            FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("Tab1.fxml"));
            Parent second = secondLoader.load();
            Tab1Controller tab1Controller = secondLoader.getController();
            helloController.SetText(textLink.getText());
            allText="qqqqq";


        }
        catch (IOException iex){
            System.out.println("not found");
        }
    }
//    private HelloController main;
//    public Tab1Controller(HelloController mClass) {
//        this.main = mClass;
//    }

}

