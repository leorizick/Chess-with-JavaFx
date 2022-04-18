package com.example.xadrezfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Scene mainScene;

    public static Scene getMainScene() {
        return mainScene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Jogo de Xadrez!");
        stage.setScene(mainScene);
        stage.show();

    }
}
