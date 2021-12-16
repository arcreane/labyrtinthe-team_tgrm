package com.tgrm.labyrtintheteam_tgrm.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Label Chrono;

    @FXML
    private ComboBox<String> btnAlgorithm;

    @FXML
    private Button btnLeave;

    @FXML
    private Button btnStart;

    @FXML
    private TextField nbrLines;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnLeave.setOnMouseClicked(Leave -> {
            System.exit(0);
        });
        btnStart.setOnMouseClicked(Start -> {
            int seconds = 0;
            int minutes = 0;

            while (minutes < 3) {
                seconds++;
                if (seconds == 60) {
                    minutes++;
                    seconds = 0;
                }
                System.out.println(minutes + ":" + seconds);
                Chrono.setText("Chrono : \n" + minutes + ":" + seconds);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }



}




