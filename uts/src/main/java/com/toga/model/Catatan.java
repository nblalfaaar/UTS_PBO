package com.toga.model;

import org.apache.commons.lang3.StringUtils;

public class Catatan {
    private final String namaPengguna;
    private final String namaTanaman;
    private String keterangan;

    public Catatan(String namaPengguna, String namaTanaman, String keterangan) {
        this.namaPengguna = namaPengguna;
        this.namaTanaman = namaTanaman;
        this.keterangan = keterangan;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getNamaTanaman() {
        return namaTanaman;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public boolean setKeterangan(String keterangan) {
        if (StringUtils.isBlank(keterangan)) {
            System.out.println("Keterangan tidak boleh kosong.");
            return false;
        } else {
            this.keterangan = keterangan;
            return true;
        }
    }

    public String buatRingkasan(Tanaman t, Pengguna p) {
        return "Catatan: " + p.getInfoSingkat() + " menanam " + t.getInfoSingkat();
    }

    public void tampilInfo() {
        System.out.println("Pengguna    : " + getNamaPengguna());
        System.out.println("Tanaman     : " + getNamaTanaman());
        System.out.println("Keterangan  : " + getKeterangan());
    }
}