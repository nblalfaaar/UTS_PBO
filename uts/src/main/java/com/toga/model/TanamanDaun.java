package com.toga.model;

import org.apache.commons.lang3.StringUtils;

public class TanamanDaun extends Tanaman{
    private String bentukDaun;

    public TanamanDaun(String nama, String namaLatin, String manfaat, String bentukDaun) {
        super(nama, namaLatin, manfaat);
        this.bentukDaun = bentukDaun;
    }

    public String getBentukDaun() {
        return bentukDaun;
    }

    public boolean setBentukDaun(String bentukDaun) {
        if(StringUtils.isBlank(bentukDaun)) {
            System.out.println("Bentuk daun tidak boleh kosong.");
            return false;
        } else {
            this.bentukDaun = bentukDaun;
            return true;
        }
    }

    @Override
    public String getJenis() {
        return "Tanaman Daun";
    }

    @Override
    String getInfoSingkat() {
        return nama + " (" + getNamaLatin() + ") - Daun";
    }

    @Override
    public int estimasiHariPanen() {
        return 60;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis       : Tanaman Daun");
        System.out.println("Bentuk Daun : " + getBentukDaun());
    }
}
