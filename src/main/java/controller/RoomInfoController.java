package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;

public class RoomInfoController {

    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
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
    void btnRoomInfoAction(ActionEvent event) {

        colId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tbl.setItems(roomInfoDTOS);

    }

}
