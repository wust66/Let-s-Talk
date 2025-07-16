package com.example;


import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class logincontroller {
    public TextField userName;
    public PasswordField passWord;
    private demo1 mainApp;

    public void setMain(demo1 main){
        this.mainApp=main;
    }


    public void login(ActionEvent e) throws Exception {

        String username = userName.getText();
        String password = passWord.getText();
        if("wym".equals(username) && "146661".equals(password)) {
            System.out.println("登陆成功");
            mainApp.showMainView();
        }
        else {
            AlertUtil.showAlert(mainApp.getStage(),"","","账号或密码不正确");
            userName.setText("");
            passWord.setText("");

        }
       }
       }


