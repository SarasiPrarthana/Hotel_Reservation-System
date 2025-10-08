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
import model.dto.StaffInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    ObservableList<StaffInfoDTO> staffInfoDTOS = FXCollections.observableArrayList(
            new StaffInfoDTO("01","Sarasi","Manager","prarthanasarasi276@gmail.com","0774955437",50000.00),
            new StaffInfoDTO("01","Sarasi","Manager","prarthanasarasi276@gmail.com","0774955437",50000.00),
            new StaffInfoDTO("01","Sarasi","Manager","prarthanasarasi276@gmail.com","0774955437",50000.00),
            new StaffInfoDTO("01","Sarasi","Manager","prarthanasarasi276@gmail.com","0774955437",50000.00),
            new StaffInfoDTO("01","Sarasi","Manager","prarthanasarasi276@gmail.com","0774955437",50000.00)

    );

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colId1;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableView<StaffInfoDTO> tbl;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStaffId;

    @FXML
    void btnAddAction(ActionEvent event) {


        String staffId = txtStaffId.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        StaffInfoDTO staffInfoDTO = new StaffInfoDTO(staffId,name,role,email,phoneNumber,salary);
        staffInfoDTOS.add(staffInfoDTO);

        tbl.refresh();

        txtStaffId.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtSalary.setText("");

    }

    @FXML
    void btnClearAction(ActionEvent event) {

        txtStaffId.setText("");
        txtName.setText("");
        txtRole.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtSalary.setText("");

    }

    @FXML
    void btnDeleteAction(ActionEvent event) {

        StaffInfoDTO selectedRoom =tbl.getSelectionModel().getSelectedItem();
        staffInfoDTOS.remove(selectedRoom);
        tbl.refresh();

    }

    @FXML
    void btnUpdateAction(ActionEvent event) {

        StaffInfoDTO selectedRoom = tbl.getSelectionModel().getSelectedItem();

        selectedRoom.setStaffId(txtStaffId.getText());
        selectedRoom.setName(txtName.getText());
        selectedRoom.setRole(txtRole.getText());
        selectedRoom.setEmail(txtEmail.getText());
        selectedRoom.setPhoneNumber(txtPhoneNumber.getText());
        selectedRoom.setSalary(Double.parseDouble(txtSalary.getText()));

        tbl.refresh();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("role"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colId1.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tbl.setItems(staffInfoDTOS);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                txtStaffId.setText(newValue.getStaffId());
                txtName.setText(newValue.getName());
                txtRole.setText(String.valueOf(newValue.getRole()));
                txtEmail.setText(String.valueOf(newValue.getEmail()));
                txtPhoneNumber.setText(String.valueOf(newValue.getPhoneNumber()));
                txtSalary.setText(String.valueOf(newValue.getSalary()));
            }
        });


    }
}
