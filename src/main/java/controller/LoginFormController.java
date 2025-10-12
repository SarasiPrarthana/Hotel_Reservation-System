package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtUserNameId;

    @FXML
    private PasswordField txtPasswordId;

    Stage stage = new Stage();

    @FXML
    void btnLoginAction(ActionEvent event) {

        String userName = txtUserNameId.getText();
        String password = txtPasswordId.getText();

        if (userName.equals("Admin")){
            if(password.equals("1234")){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                txtUserNameId.setText("");
                txtPasswordId.setText("");
            }else{
                System.out.println("Invalid Password");
                txtUserNameId.setText("");
                txtPasswordId.setText("");

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Password");
                alert.setContentText("Please enter valid user name and password");
                alert.showAndWait();
            }
        }else{
            System.out.println("Invalid UserName");
            txtUserNameId.setText("");
            txtPasswordId.setText("");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid UserName");
            alert.setContentText("Please enter valid user name and password");
            alert.showAndWait();
        }

    }



}
