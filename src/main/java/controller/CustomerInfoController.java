package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerInfoDTO;
import model.dto.RoomInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("01","Sarasi",22,"0774955437","Panadura"),
            new CustomerInfoDTO("02","Sarasi",18,"0774955437","Colombo"),
            new CustomerInfoDTO("03","Sarasi",20,"0774955437","Moratuwa"),
            new CustomerInfoDTO("04","Sarasi",21,"0774955437","Negombo"),
            new CustomerInfoDTO("05","Sarasi",19,"0774955437","Kaluthara")
    );

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<CustomerInfoDTO> tbl;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnAddAction(ActionEvent event) {

        String customerId = txtCustomerId.getText();
        String name = txtName.getText();
        int age = Integer.parseInt(txtAge.getText());
        String phoneNumber = txtPhoneNumber.getText();
        String city = txtCity.getText();

        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO(customerId,name,age,phoneNumber,city);
        customerInfoDTOS.add(customerInfoDTO);

        tbl.refresh();

        txtCustomerId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNumber.setText("");
        txtCity.setText("");

    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtCustomerId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtPhoneNumber.setText("");
        txtCity.setText("");
    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        CustomerInfoDTO selectedRoom =tbl.getSelectionModel().getSelectedItem();
        customerInfoDTOS.remove(selectedRoom);
        tbl.refresh();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        CustomerInfoDTO selectedRoom = tbl.getSelectionModel().getSelectedItem();

        selectedRoom.setCustomerId(txtCustomerId.getText());
        selectedRoom.setName(txtName.getText());
        selectedRoom.setAge(Integer.parseInt(txtAge.getText()));
        selectedRoom.setPhoneNumber(txtPhoneNumber.getText());
        selectedRoom.setCity(txtCity.getText());

        tbl.refresh();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        tbl.setItems(customerInfoDTOS);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtCustomerId.setText(newValue.getCustomerId());
                txtName.setText(newValue.getName());
                txtAge.setText(String.valueOf(newValue.getAge()));
                txtPhoneNumber.setText(String.valueOf(newValue.getPhoneNumber()));
                txtCity.setText(String.valueOf(newValue.getCity()));
            }
        });


    }
}
