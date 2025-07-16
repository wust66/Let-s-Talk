package com.example;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class AlertUtil {
    public static void showAlert(Stage primaryStage, String title, String
            headerText, String contentText) {
//弹出式对话框统一使用Alert类
//常量AlertType.WARNING代表警告对话框
        Alert alert = new Alert(Alert.AlertType.WARNING);
//所有的弹出式对话框的父窗口为MainApp类中获取的Stage类型对象primaryStage
        alert.initOwner(primaryStage);
//弹出式对话框的提示文字
        alert.setTitle(title);
//弹出式对话框的标题文字
        alert.setHeaderText(headerText);
//弹出式对话框的文字内容
        alert.setContentText(contentText);
//显示弹出式对话框，并等待用户的点击“确定”按钮
        alert.showAndWait();
    }

    public static boolean showConfirm(Stage primaryStage) {
//常量AlertType.CONFIRMATION代表确认对话框
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//initOwner()、setHeaderText()、setContentText()使用同上
        alert.initOwner(primaryStage);
        alert.setHeaderText("删除警告");
        alert.setContentText("确实要删除数据吗？");
//确认对话框上有“确定”和“取消”两个按钮，统一用Optional<ButtonType> 类型表示
        Optional<ButtonType> buttonType = alert.showAndWait();

        if
        (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.OK_DONE)) {
            return true;
        } else {
// 否则返回假值
            return false;
        }
    }
}
