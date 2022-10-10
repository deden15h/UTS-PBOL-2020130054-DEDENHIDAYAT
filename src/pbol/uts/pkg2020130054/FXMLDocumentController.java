/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pbol.uts.pkg2020130054;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author deden hidayat
 */
public class FXMLDocumentController implements Initializable {

    public static DBMahasiswa dtmahasiswa = new DBMahasiswa();
    public static DBJadwal dtjadwal = new DBJadwal();

    @FXML
    private MenuItem MasterMahasiswa;
    @FXML
    private MenuItem MasterMataKuliah;
    @FXML
    private MenuItem MasterJadwal;
    @FXML
    private MenuItem DisplayMahasiswa;
    @FXML
    private MenuItem DisplayMataKuliah;
    @FXML
    private MenuItem DisplayJadwal;
    @FXML
    private Menu Keluar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void MasterMahasiswaKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void MasterMataKuliahKlik(ActionEvent event) {
    }

    @FXML
    private void MasterJadwalKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputJadwal.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void DisplayMahasiswaKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void DisplayMataKuliahKlik(ActionEvent event) {
    }

    @FXML
    private void DisplayJadwalKlik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_DisplayJadwal.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void KeluarKlik(ActionEvent event) {
        System.exit(0);
    }

}
