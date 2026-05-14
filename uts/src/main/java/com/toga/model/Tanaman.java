package com.toga.model;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;

public class Tanaman {
    protected String nama;
    private String namaLatin;
    private String manfaat;

    public Tanaman(String nama, String namaLatin, String manfaat) {
        this.nama = nama;
        this.namaLatin = namaLatin;
        this.manfaat = manfaat;
    }

    public String getNama() {
        return nama;
    }

    public String getNamaLatin() {
        return namaLatin;
    }

    public String getManfaat() {
        return manfaat;
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

    public boolean setNamaLatin(String namaLatin) {
        if (StringUtils.isBlank(namaLatin)) {
            System.out.println("Nama latin tidak boleh kosong.");
            return false;
        } else {
            this.namaLatin = namaLatin;
            return true;
        }
    }

    public boolean setManfaat(String manfaat) {
        if (StringUtils.isBlank(manfaat)) {
            System.out.println("Manfaat tidak boleh kosong.");
            return false;
        } else {
            this.manfaat = manfaat;
            return true;
        }
    }

    String getInfoSingkat() {
        return nama + " (" + namaLatin + ")";
    }

    // method untuk mendapatkan jenis, akan di-override subclass
    public String getJenis() {
        return "Tanaman Umum";
    }

    public void tampilInfo() {
        System.out.println("Nama        : " + getNama());
        System.out.println("Nama Latin  : " + getNamaLatin());
        System.out.println("Manfaat     : " + getManfaat());
    }

    public int estimasiHariPanen() {
        return 90;
    }

    public int estimasiHariPanen(String tujuan) {
        int dasar = estimasiHariPanen();

        if (tujuan.equalsIgnoreCase("bibit")) {
            return dasar + 30;
        } else if (tujuan.equalsIgnoreCase("konsumsi")) {
            return dasar;
        } else if (tujuan.equalsIgnoreCase("obat")) {
            return dasar + 45;
        }
        return dasar;
    }

    public static int hitungTanaman(ArrayList<Tanaman> daftarTanaman) {
        return daftarTanaman.size();
    }

    public static int hitungTanaman(ArrayList<Tanaman> daftarTanaman, String jenis) {
        int count = 0;
        for (Tanaman t : daftarTanaman) {
            if (t.getJenis().equalsIgnoreCase(jenis)) {
                count++;
            }
        }
        return count;
    }
}