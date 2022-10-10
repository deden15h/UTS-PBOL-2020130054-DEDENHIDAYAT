/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol.uts.pkg2020130054;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_DisplayMahasiswaController implements Initializable {

    @FXML
    private TableView<MahasiswaModel> tbvmahasiswa;
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
        ObservableList<MahasiswaModel> data = FXMLDocumentController.dtmahasiswa.Load();
        if (data != null) {
            tbvmahasiswa.getColumns().clear();
            tbvmahasiswa.getItems().clear();
            TableColumn col = new TableColumn("npm");
            col.setCellValueFactory(new PropertyValueFactory<MahasiswaModel, String>("npm"));
            tbvmahasiswa.getColumns().addAll(col);
            col = new TableColumn("nama");
            col.setCellValueFactory(new PropertyValueFactory<MahasiswaModel, String>("nama"));
            tbvmahasiswa.getColumns().addAll(col);
            col = new TableColumn("alamat");
            col.setCellValueFactory(new PropertyValueFactory<MahasiswaModel, String>("alamat"));
            tbvmahasiswa.getColumns().addAll(col);
            tbvmahasiswa.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvmahasiswa.getScene().getWindow().hide();;
        }
    }

    @FXML
    private void tambahklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
        
    }

    @FXML
    private void ubahklik(ActionEvent event) {
        MahasiswaModel s = new MahasiswaModel();
        s = tbvmahasiswa.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputMahasiswaController isidt = (FXML_InputMahasiswaController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
        

    }

    @FXML
    private void hapusklik(ActionEvent event) {
        MahasiswaModel s = new MahasiswaModel();
        s = tbvmahasiswa.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtmahasiswa.delete(s.getNpm())) {
                Alert b = new Alert(Alert.AlertType.INFORMATION, "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR, "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showdata();
            

        }
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();

    }

}
