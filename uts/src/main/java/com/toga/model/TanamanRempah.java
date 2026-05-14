package com.toga.model;

import org.apache.commons.lang3.StringUtils;

public class TanamanRempah extends Tanaman{
    private String aroma;

    public TanamanRempah(String nama, String namaLatin, String manfaat, String aroma) {
        super(nama, namaLatin, manfaat);
        this.aroma = aroma;
    }

    public String getAroma() {
        return aroma;
    }

    public boolean setAroma(String aroma) {
        if (StringUtils.isBlank(aroma)) {
            System.out.println("Aroma tidak boleh kosong.");
            return false;
        } else {
            this.aroma = aroma;
            return true;
        }
    }

    @Override
    public String getJenis() {
        return "Tanaman Rempah";
    }

    @Override
    String getInfoSingkat() {
        return nama + " (" + getNamaLatin() + ") - Rempah";
    }

    @Override
    public int estimasiHariPanen() {
        return 240;
    }

    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Jenis       : Tanaman Rempah");
        System.out.println("Aroma       : " + getAroma());
    }
}
