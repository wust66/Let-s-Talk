package com.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Stack;

public class demo1 extends Application{
    private GridPane gp;
    private AnchorPane bp;
    private Stage stage;
    public void start(Stage stage )throws Exception{
        this.stage=stage;
        init(stage);
    }
    public Stage getStage(){
        return stage;
    }

    public void init(Stage stage)throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(demo1.class.getResource("login.fxml"));
        gp=loader.load();
        Scene scene=new Scene(gp,400,400);
        stage.setScene(scene);
        stage.setTitle("登录");
        stage.show();

        logincontroller logincontroller=loader.getController();
        logincontroller.setMain(this);
    }
    public void showMainView()throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(demo1.class.getResource("main.fxml"));
        bp=loader.load();
        Scene scene=new Scene(bp,600,600);
        stage.setScene(scene);
        stage.setTitle("聊天吧");
        stage.show();

        Maincontroller maincontroller=loader.getController();
        maincontroller.setMainview(bp);
    }
    public static void main(String [] args){
        launch(args);
    }

}
