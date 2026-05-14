package com.toga.model;

import org.apache.commons.lang3.StringUtils;

public class TanamanBuah extends Tanaman{
    private String musimBerbuah;

    public TanamanBuah(String nama, String namaLatin, String manfaat, String musimBerbuah) {
        super(nama, namaLatin, manfaat);
        this.musimBerbuah = musimBerbuah;
    }

    public String getMusimBerbuah() {
        return musimBerbuah;
    }

    public boolean setMusimBerbuah(String musimBerbuah) {
        if (StringUtils.isBlank(musimBerbuah)) {
            System.out.println("Musim berbuah tidak boleh kosong.");
            return false;
        } else {
            this.musimBerbuah = musimBerbuah;
            return true;
        }
    }

    @Override
    public String getJenis() {
        return "Tanaman Buah";
    }

    @Override
    String getInfoSingkat() {
        return nama + " (" + getNamaLatin() + ") - Buah";
    }

    @Override
    public int estimasiHariPanen() {
        return 180;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis         : Tanaman Buah");
        System.out.println("Musim Berbuah : " + getMusimBerbuah());
    }
}
