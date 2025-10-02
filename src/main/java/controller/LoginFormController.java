package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    Stage stage = new Stage();

    @FXML
    void btnLoginOnAction(ActionEvent event) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userName.equals("Admin")){
            if(password.equals("1234")){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                txtUserName.setText("");
                txtPassword.setText("");
            }else{
                System.out.println("Invalid Password");
                txtUserName.setText("");
                txtPassword.setText("");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Password");
                alert.setContentText("Please enter valid user name and password");
                alert.showAndWait();
            }
        }else{
            System.out.println("Invalid UserName");
            txtUserName.setText("");
            txtPassword.setText("");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid UserName");
            alert.setContentText("Please enter valid user name and password");
            alert.showAndWait();
        }

    }



}
