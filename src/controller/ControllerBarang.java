/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelBarang;
import util.Koneksi;

/**
 *
 * @author Mr.Al
 */
public class ControllerBarang {

    Koneksi cn = new Koneksi();

    public void simpanData(ModelBarang mb) {
        cn.koneksiDatabase();
        String query = "insert into tbl_barang(nama,jenis,jumlah) values ('" + mb.getNama() + "','" + mb.getJenis() + "','" + mb.getJumlah() + "')";
        try {
            cn.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        } catch (SQLException e) {
            System.err.println("" + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Tersimpan");
        }
    }

    public void hapusData(ModelBarang mb) {
        try {
            cn.koneksiDatabase();
            String query = "delete from tbl_barang where id =('" + mb.getId() + "')";
            cn.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Terhapus");
        } catch (SQLException e) {
            System.err.println("" + e);
            JOptionPane.showMessageDialog(null, "Data Tidak Terhapus");
        }
    }

    public void ubahData(ModelBarang mb) {
        cn.koneksiDatabase();
        try {
            int id = mb.getId();
            int jumlah = mb.getJumlah();
            String nama = mb.getNama();
            String jenis = mb.getJenis();

            String query = "update tbl_barang set nama = ('" + nama + "'),"
                    + "jenis = ('" + jenis + "'),jumlah = ('" + jumlah + "') where id = ('" + id + "')";
            cn.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Terupdate");
        } catch (SQLException e) {
            System.err.println("" + e);
        }

    }

}
