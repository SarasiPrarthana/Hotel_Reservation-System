package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfoController implements Initializable {

    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
           new RoomInfoDTO("R001", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R002", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R003", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R001", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R002", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R003", "Single", "A room assigned to one person", 1000.0),
            new RoomInfoDTO("R004", "Double", "A room assigned to one person", 1000.0)
    );

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<RoomInfoDTO> tbl;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtType;



    @FXML
    void btnAddAction(ActionEvent event) {

        String roomID = txtRoomId.getText();
        String type = txtType.getText();
        String description = txtDescription.getText();
        Double price = Double.valueOf(txtPrice.getText());

        RoomInfoDTO roomInfoDTO = new RoomInfoDTO(roomID,type,description,price);
        roomInfoDTOS.add(roomInfoDTO);

        tbl.refresh();

        txtRoomId.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtRoomId.setText("");
        txtType.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        RoomInfoDTO selectedRoom =tbl.getSelectionModel().getSelectedItem();
        roomInfoDTOS.remove(selectedRoom);
        tbl.refresh();
//        RoomInfoDTO selectedRoom = tbl.getSelectionModel().getSelectedItem();
//        if (selectedRoom != null) {
//            roomInfoDTOS.remove(selectedRoom);
//            tbl.refresh();
//        }

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        RoomInfoDTO selectedRoom = tbl.getSelectionModel().getSelectedItem();

        selectedRoom.setRoomId(txtRoomId.getText());
        selectedRoom.setDescription(txtDescription.getText());
        selectedRoom.setType(txtType.getText());
        selectedRoom.setPrice(Double.valueOf(txtPrice.getText()));

        tbl.refresh();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tbl.setItems(roomInfoDTOS);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtRoomId.setText(newValue.getRoomId());
                txtType.setText(newValue.getType());
                txtDescription.setText(newValue.getDescription());
                txtPrice.setText(String.valueOf(newValue.getPrice()));
            }
        });

    }
}
