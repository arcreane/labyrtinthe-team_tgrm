package com.tgrm.labyrtintheteam_tgrm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MazeController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MazeController.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1680, 1050);
        stage.setTitle("TMGR Maze");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}