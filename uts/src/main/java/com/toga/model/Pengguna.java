package com.toga.model;

import org.apache.commons.lang3.StringUtils;

public class Pengguna {
    private String nama;
    private String alamat;

    public Pengguna(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public boolean setNama(String nama) {
        if (StringUtils.isBlank(nama)) {
            System.out.println("Nama tidak boleh kosong.");
            return false;
        } else {
            this.nama = nama;
            return true;
        }
    }

    public boolean setAlamat(String alamat) {
        if (StringUtils.isBlank(alamat)) {
            System.out.println("Alamat tidak boleh kosong.");
            return false;
        } else {
            this.alamat = alamat;
            return true;
        }
    }

    String getInfoSingkat() {
        return nama + " - " + alamat;
    }

    public void tampilInfo() {
        System.out.println("Nama    : " + getNama());
        System.out.println("Alamat  : " + getAlamat());
    }
}