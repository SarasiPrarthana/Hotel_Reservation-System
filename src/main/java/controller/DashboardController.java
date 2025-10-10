package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    Stage stage = new Stage();
    @FXML
    void btnCustomerInfoAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_info.fxml"))));
        stage.show();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}

@FXML
void btnRoomInfoAction(ActionEvent event) {
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/room_info.fxml"))));
        stage.show();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}

@FXML
void btnStaffInfoAction(ActionEvent event) {
    try {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/staff.fxml"))));
        stage.show();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
}
