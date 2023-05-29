package com.example.notelist_fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.concurrent.atomic.AtomicReference;

public class Tab2Controller {
    @FXML
    private TextArea allNotes;

    private StringBuilder text = new StringBuilder("");
    private AtomicReference<String> r= new AtomicReference<>("");
    @FXML
    protected void sort(ActionEvent event) {
        text.append("0");
        allNotes.setText(text.toString());
    }
}
