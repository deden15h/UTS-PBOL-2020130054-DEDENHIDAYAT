/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbol.uts.pkg2020130054;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author deden hidayat
 */
public class FXML_InputJadwalController implements Initializable {
    
    boolean editdata = false;
    @FXML
    private Button btnsbatal;

    public void execute(JadwalModel d) {
        if (!d.getNpm().isEmpty()) {
            editdata = true;
            txtnpm.setText(d.getNpm());
            txtkodemk.setText(d.getKodeMK());
            txtruang.setText(d.getRuang());
            txthari.setText(d.getHari());
            txtwaktu.setText(d.getWaktu());
            txtnpm.setEditable(false);
            txtnpm.requestFocus();
        }
    }

    @FXML
    private TextField txtnpm;
    @FXML
    private TextField txtkodemk;
    @FXML
    private TextField txtruang;
    @FXML
    private TextField txthari;
    @FXML
    private TextField txtwaktu;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
        JadwalModel dt = new JadwalModel();
        dt.setNpm(txtnpm.getText());
        dt.setKodeMK(txtkodemk.getText());
        dt.setRuang(txtruang.getText());
        dt.setHari(txthari.getText());
        dt.setWaktu(txtwaktu.getText());
        FXMLDocumentController.dtjadwal.setDt(dt);
        if (editdata) {
            if (FXMLDocumentController.dtjadwal.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtnpm.setEditable(true);
                batalklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtjadwal.validasi(dt.getNpm()) <= 0) {
            if (FXMLDocumentController.dtjadwal.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();
                batalklik(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtnpm.requestFocus();
        }
    }

    @FXML
    private void keluarklik(ActionEvent event) {
        btnkeluar.getScene().getWindow().hide();
    }

    @FXML
    private void batalklik(ActionEvent event) {
        txtnpm.setText("");
        txtkodemk.setText("");
        txtruang.setText("");
        txthari.setText("");
        txtwaktu.setText("");
    }
    
}
