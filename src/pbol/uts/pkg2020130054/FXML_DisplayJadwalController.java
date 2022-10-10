/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol.uts.pkg2020130054;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_DisplayJadwalController implements Initializable {

    @FXML
    private TableView<JadwalModel> tbvjadwal;
    @FXML
    private Button btntambah;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
    }

    private void showdata() {
        ObservableList<JadwalModel> data = FXMLDocumentController.dtjadwal.Load();
        if (data != null) {
            tbvjadwal.getColumns().clear();
            tbvjadwal.getItems().clear();
            TableColumn col = new TableColumn("npm");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("npm"));
            tbvjadwal.getColumns().addAll(col);
            col = new TableColumn("kodeMK");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("kodeMK"));
            tbvjadwal.getColumns().addAll(col);
            col = new TableColumn("ruangan");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("ruangan"));
            tbvjadwal.getColumns().addAll(col);
            col = new TableColumn("hari");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("hari"));
            tbvjadwal.getColumns().addAll(col);
            col = new TableColumn("waktu");
            col.setCellValueFactory(new PropertyValueFactory<JadwalModel, String>("waktu"));
            tbvjadwal.getColumns().addAll(col);
            tbvjadwal.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvjadwal.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void tambahklik(ActionEvent event) {
    }

    @FXML
    private void ubahklik(ActionEvent event) {
    }

    @FXML
    private void hapusklik(ActionEvent event) {
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }

}
