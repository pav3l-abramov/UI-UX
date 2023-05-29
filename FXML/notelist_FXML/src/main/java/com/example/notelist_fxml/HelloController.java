package com.example.notelist_fxml;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {
    @FXML
    Tab tab1;
    @FXML
    Tab tab2;
    @FXML
    Tab tab3;
    @FXML
    private TextArea allNotes ;
    @FXML
    private AnchorPane ancho ;

    public String textFrag;


    public void SetText(String text)  {
        textFrag=text;
        allNotes.appendText(text);

        System.out.println("1"+allNotes.getText());
        System.out.println("2"+textFrag);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXMLLoader loader =new FXMLLoader();
        try {
            AnchorPane anch1 = loader.load(getClass().getResource("Tab1.fxml"));
            tab1.setContent(anch1);
        }
        catch (IOException iex){
            System.out.println("not found");
        }
        loader=new FXMLLoader();

        try {
            AnchorPane anch2 = loader.load(getClass().getResource("Tab2.fxml"));
            tab2.setContent(anch2);
        }
        catch (IOException iex){
            System.out.println("not found");
        }

        loader=new FXMLLoader();

        try {
            AnchorPane anch3 = loader.load(getClass().getResource("Tab3.fxml"));
            tab3.setContent(anch3);
        }
        catch (IOException iex){
            System.out.println("not found");
        }
        //if (textFrag!=null)allNotes.setText(textFrag);
//        if (allText!=null)allNotes.appendText(allText);
//        System.out.println(allText);
//      System.out.println(allNotes.getText());
//        //System.out.println("4"+textFrag);
//        System.out.println(textLink);
    }

}
