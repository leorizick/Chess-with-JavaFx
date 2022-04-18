package com.example.xadrezfx;

import com.example.xadrezfx.GUI.Alerts;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MenuController implements Initializable {
    @FXML
    private MenuItem newGame;
    @FXML
    private MenuItem about;
    @FXML
    private MenuItem backToMenu;
    @FXML
    private Button titleNewGame;
    @FXML
    private Button titleAbout;


    @FXML
    public void onNewGameAction() {
        loadViewAbout("xadrez.fxml");
    }

    @FXML
    public void onBackToMenuAction() {
        loadViewAbout("menu.fxml");
    }

    @FXML
    public void onAboutAction() {
        loadViewAbout("About.fxml");
    }

    @FXML
    public void onTitleAboutAction() {
        loadViewAbout("About.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private void loadViewAbout(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) mainScene.getRoot();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVbox.getChildren());


        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Erro carregando pagina", e.getMessage(), Alert.AlertType.ERROR);
        }
    }



}