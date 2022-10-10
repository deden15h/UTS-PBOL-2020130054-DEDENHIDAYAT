/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbol.uts.pkg2020130054;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author deden hidayat
 */
public class DBJadwal {
    private JadwalModel dt = new JadwalModel();

    public JadwalModel getDt() {
        return (dt);
    }

    public void setDt(JadwalModel dt) {
        this.dt = dt;
    }
    
    public ObservableList<JadwalModel> Load() {
        try {
            ObservableList<JadwalModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select npm, kodeMK, ruangan, hari, waktu from jadwal");
            int i = 1;
            while (rs.next()) {
                JadwalModel d = new JadwalModel();
                d.setNpm(rs.getString("npm"));
                d.setKodeMK(rs.getString("kodeMK"));
                d.setWaktu(rs.getString("waktu"));
                d.setRuang(rs.getString("ruangan"));
                d.setHari(rs.getString("hari"));
                TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int validasi(String nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from mahasiswa where npm = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into jadwal (npm, kodeMK, ruangan, hari, waktu) values (?,?,?,?,?)");
            con.preparedStatement.setString(1, getDt().getNpm());
            con.preparedStatement.setString(2, getDt().getKodeMK());
            con.preparedStatement.setString(3, getDt().getRuang());
            con.preparedStatement.setString(3, getDt().getHari());
            con.preparedStatement.setString(3, getDt().getWaktu());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from jadwal where npm  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update mahasiswa set kodeMK = ?, ruangan = ?, hari = ?, waktu = ?  where  npm = ? ; ");
            con.preparedStatement.setString(1, getDt().getKodeMK());
            con.preparedStatement.setString(2, getDt().getRuang());
            con.preparedStatement.setString(2, getDt().getHari());
            con.preparedStatement.setString(2, getDt().getWaktu());
            con.preparedStatement.setString(3, getDt().getNpm());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
}
