/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mr.Al
 */
public class ModelBarang {
    
    int id, jumlah;
    String nama, jenis;

    public int getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
    
    
}
