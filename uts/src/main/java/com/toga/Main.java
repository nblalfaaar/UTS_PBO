package com.toga;

import com.toga.model.Tanaman;
import com.toga.model.TanamanRempah;
import com.toga.model.TanamanDaun;
import com.toga.model.TanamanBuah;
import com.toga.model.Pengguna;
import com.toga.model.Catatan;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void garis(int lebar) {
        System.out.println("+" + "=".repeat(lebar) + "+");
    }

    static void garisTipis(int lebar) {
        System.out.println("+" + "-".repeat(lebar) + "+");
    }

    static void baris(String teks, int lebar) {
        System.out.printf("| %-" + (lebar - 1) + "s|%n", teks);
    }

    static void judulBox(String judul, int lebar) {
        garis(lebar);
        int pad = (lebar - judul.length()) / 2;
        String s = " ".repeat(Math.max(pad, 1)) + judul;
        System.out.printf("|%-" + lebar + "s|%n", s);
        garis(lebar);
    }

    static void pesanOk(String pesan) {
        System.out.println("  [OK] " + pesan);
    }

    static void pesanError(String pesan) {
        System.out.println("  [!]  " + pesan);
    }

    static String potong(String s, int maks) {
        if (s == null) return "";
        return s.length() > maks ? s.substring(0, maks - 2) + ".." : s;
    }

    static void tampilMenuUtama() {
        System.out.println();
        judulBox("SISTEM MANAJEMEN TOGA", 30);
        baris("1. Kelola Data Tanaman", 30);
        baris("2. Kelola Data Pengguna", 30);
        baris("3. Kelola Data Catatan", 30);
        garisTipis(30);
        baris("0. Keluar", 30);
        garisTipis(30);
        System.out.print("  Pilih menu : ");
    }

    static void tampilMenuTanaman() {
        System.out.println();
        judulBox("MENU TANAMAN", 30);
        baris("1. Tambah Tanaman", 30);
        baris("2. Lihat Semua Tanaman", 30);
        baris("3. Ubah Tanaman", 30);
        baris("4. Hapus Tanaman", 30);
        baris("5. Statistik Tanaman", 30);
        baris("6. Estimasi Masa Panen", 30);
        garisTipis(30);
        baris("0. Kembali", 30);
        garisTipis(30);
        System.out.print("  Pilih : ");
    }

    static void tampilMenuPengguna() {
        System.out.println();
        judulBox("MENU PENGGUNA", 30);
        baris("1. Tambah Pengguna", 30);
        baris("2. Lihat Semua Pengguna", 30);
        baris("3. Ubah Pengguna", 30);
        baris("4. Hapus Pengguna", 30);
        garisTipis(30);
        baris("0. Kembali", 30);
        garisTipis(30);
        System.out.print("  Pilih : ");
    }

    static void tampilMenuCatatan() {
        System.out.println();
        judulBox("MENU CATATAN", 30);
        baris("1. Tambah Catatan", 30);
        baris("2. Lihat Semua Catatan", 30);
        baris("3. Ubah Catatan", 30);
        baris("4. Hapus Catatan", 30);
        garisTipis(30);
        baris("0. Kembali", 30);
        garisTipis(30);
        System.out.print("  Pilih : ");
    }

    static void tampilTabelTanaman(ArrayList<Tanaman> list) {
        System.out.println();
        String fmt = "| %-3s | %-18s | %-16s | %-14s | %-20s |";
        String grs = "+-" + "-".repeat(3) + "-+-" + "-".repeat(18) + "-+-"
                + "-".repeat(16) + "-+-" + "-".repeat(14) + "-+-"
                + "-".repeat(20) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "No", "Nama", "Nama Latin", "Jenis", "Manfaat");
        System.out.println(grs);
        for (int i = 0; i < list.size(); i++) {
            Tanaman t = list.get(i);
            System.out.printf(fmt + "%n",
                    i + 1,
                    potong(t.getNama(), 18),
                    potong(t.getNamaLatin(), 16),
                    potong(t.getJenis(), 14),
                    potong(t.getManfaat(), 20));
        }
        System.out.println(grs);
    }

    static void tampilTabelPengguna(ArrayList<Pengguna> list) {
        System.out.println();
        String fmt = "| %-3s | %-22s | %-28s |";
        String grs = "+-" + "-".repeat(3) + "-+-" + "-".repeat(22) + "-+-" + "-".repeat(28) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "No", "Nama", "Alamat");
        System.out.println(grs);
        for (int i = 0; i < list.size(); i++) {
            Pengguna p = list.get(i);
            System.out.printf(fmt + "%n",
                    i + 1,
                    potong(p.getNama(), 22),
                    potong(p.getAlamat(), 28));
        }
        System.out.println(grs);
    }

    static void tampilTabelCatatan(ArrayList<Catatan> list) {
        System.out.println();
        String fmt = "| %-3s | %-18s | %-18s | %-26s |";
        String grs = "+-" + "-".repeat(3) + "-+-" + "-".repeat(18) + "-+-"
                + "-".repeat(18) + "-+-" + "-".repeat(26) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "No", "Pengguna", "Tanaman", "Keterangan");
        System.out.println(grs);
        for (int i = 0; i < list.size(); i++) {
            Catatan c = list.get(i);
            System.out.printf(fmt + "%n",
                    i + 1,
                    potong(c.getNamaPengguna(), 18),
                    potong(c.getNamaTanaman(), 18),
                    potong(c.getKeterangan(), 26));
        }
        System.out.println(grs);
    }

    static void tampilStatistik(ArrayList<Tanaman> list) {
        System.out.println();
        judulBox("STATISTIK TANAMAN", 32);
        String fmt = "| %-22s | %-5s |";
        String grs = "+-" + "-".repeat(22) + "-+-" + "-".repeat(5) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "Jenis", "Total");
        System.out.println(grs);
        System.out.printf(fmt + "%n", "Semua Tanaman",  Tanaman.hitungTanaman(list));
        System.out.printf(fmt + "%n", "Tanaman Rempah", Tanaman.hitungTanaman(list, "Tanaman Rempah"));
        System.out.printf(fmt + "%n", "Tanaman Daun",   Tanaman.hitungTanaman(list, "Tanaman Daun"));
        System.out.printf(fmt + "%n", "Tanaman Buah",   Tanaman.hitungTanaman(list, "Tanaman Buah"));
        System.out.println(grs);
    }

    static void tampilEstimasi(ArrayList<Tanaman> list, String tujuan) {
        System.out.println();
        judulBox("ESTIMASI PANEN - " + tujuan.toUpperCase(), 52);
        String fmt = "| %-18s | %-14s | %-9s | %-12s |";
        String grs = "+-" + "-".repeat(18) + "-+-" + "-".repeat(14) + "-+-"
                + "-".repeat(9) + "-+-" + "-".repeat(12) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "Nama Tanaman", "Jenis", "Hari", "Bulan+Hari");
        System.out.println(grs);
        for (Tanaman t : list) {
            int hari  = t.estimasiHariPanen(tujuan);
            int bulan = hari / 30;
            int sisa  = hari % 30;
            System.out.printf(fmt + "%n",
                    potong(t.getNama(), 18),
                    potong(t.getJenis(), 14),
                    hari + " hr",
                    bulan + " bln " + sisa + " hr");
        }
        System.out.println(grs);
    }

    static void tampilPilihTanaman(ArrayList<Tanaman> list) {
        String fmt = "| %-3s | %-20s | %-14s |";
        String grs = "+-" + "-".repeat(3) + "-+-" + "-".repeat(20) + "-+-" + "-".repeat(14) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "No", "Nama", "Jenis");
        System.out.println(grs);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(fmt + "%n",
                    i + 1,
                    potong(list.get(i).getNama(), 20),
                    potong(list.get(i).getJenis(), 14));
        }
        System.out.println(grs);
    }

    static void tampilPilihPengguna(ArrayList<Pengguna> list) {
        String fmt = "| %-3s | %-22s |";
        String grs = "+-" + "-".repeat(3) + "-+-" + "-".repeat(22) + "-+";
        System.out.println(grs);
        System.out.printf(fmt + "%n", "No", "Nama");
        System.out.println(grs);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(fmt + "%n", i + 1, potong(list.get(i).getNama(), 22));
        }
        System.out.println(grs);
    }

    public static void main(String[] args) {
        ArrayList<Tanaman>  daftarTanaman  = new ArrayList<>();
        ArrayList<Pengguna> daftarPengguna = new ArrayList<>();
        ArrayList<Catatan>  daftarCatatan  = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            tampilMenuUtama();
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    int sub;
                    do {
                        tampilMenuTanaman();
                        sub = sc.nextInt();
                        sc.nextLine();

                        if (sub == 1) {
                            System.out.println();
                            judulBox("TAMBAH TANAMAN", 30);
                            baris("1. Tanaman Rempah", 30);
                            baris("2. Tanaman Daun",   30);
                            baris("3. Tanaman Buah",   30);
                            garisTipis(30);
                            System.out.print("  Pilih jenis  : ");
                            int jenis = sc.nextInt();
                            sc.nextLine();

                            String nama;
                            do {
                                System.out.print("  Nama Tanaman  : ");
                                nama = sc.nextLine();
                                if (StringUtils.isBlank(nama)) {
                                    pesanError("Nama tidak boleh kosong!");
                                }
                            } while (StringUtils.isBlank(nama));

                            String namaLatin;
                            do {
                                System.out.print("  Nama Latin    : ");
                                namaLatin = sc.nextLine();
                                if (StringUtils.isBlank(namaLatin)) {
                                    pesanError("Nama latin tidak boleh kosong!");
                                }
                            } while (StringUtils.isBlank(namaLatin));

                            String manfaat;
                            do {
                                System.out.print("  Manfaat       : ");
                                manfaat = sc.nextLine();
                                if (StringUtils.isBlank(manfaat)) {
                                    pesanError("Manfaat tidak boleh kosong!");
                                }
                            } while (StringUtils.isBlank(manfaat));

                            switch (jenis) {
                                case 1:
                                    String aroma;
                                    do {
                                        System.out.print("  Aroma         : ");
                                        aroma = sc.nextLine();
                                        if (StringUtils.isBlank(aroma)) {
                                            pesanError("Aroma tidak boleh kosong!");
                                        }
                                    } while (StringUtils.isBlank(aroma));
                                    daftarTanaman.add(new TanamanRempah(nama, namaLatin, manfaat, aroma));
                                    pesanOk("Tanaman Rempah berhasil ditambahkan!");
                                    break;
                                case 2:
                                    String bentukDaun;
                                    do {
                                        System.out.print("  Bentuk Daun   : ");
                                        bentukDaun = sc.nextLine();
                                        if (StringUtils.isBlank(bentukDaun)) {
                                            pesanError("Bentuk daun tidak boleh kosong!");
                                        }
                                    } while (StringUtils.isBlank(bentukDaun));
                                    daftarTanaman.add(new TanamanDaun(nama, namaLatin, manfaat, bentukDaun));
                                    pesanOk("Tanaman Daun berhasil ditambahkan!");
                                    break;
                                case 3:
                                    String musimBerbuah;
                                    do {
                                        System.out.print("  Musim Berbuah : ");
                                        musimBerbuah = sc.nextLine();
                                        if (StringUtils.isBlank(musimBerbuah)) {
                                            pesanError("Musim berbuah tidak boleh kosong!");
                                        }
                                    } while (StringUtils.isBlank(musimBerbuah));
                                    daftarTanaman.add(new TanamanBuah(nama, namaLatin, manfaat, musimBerbuah));
                                    pesanOk("Tanaman Buah berhasil ditambahkan!");
                                    break;
                                default:
                                    pesanError("Jenis tidak valid.");
                                    break;
                            }

                        } else if (sub == 2) {
                            if (daftarTanaman.isEmpty()) {
                                pesanError("Belum ada data tanaman.");
                            } else {
                                tampilTabelTanaman(daftarTanaman);
                            }

                        } else if (sub == 3) {
                            if (daftarTanaman.isEmpty()) {
                                pesanError("Belum ada data tanaman.");
                            } else {
                                tampilPilihTanaman(daftarTanaman);
                                System.out.print("  Pilih nomor  : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarTanaman.size()) {
                                    Tanaman t = daftarTanaman.get(no - 1);
                                    System.out.print("  Nama Tanaman  : ");
                                    while (!t.setNama(sc.nextLine()))     System.out.print("  Nama Tanaman  : ");
                                    System.out.print("  Nama Latin    : ");
                                    while (!t.setNamaLatin(sc.nextLine())) System.out.print("  Nama Latin    : ");
                                    System.out.print("  Manfaat       : ");
                                    while (!t.setManfaat(sc.nextLine()))  System.out.print("  Manfaat       : ");
                                    if (t instanceof TanamanRempah) {
                                        TanamanRempah tr = (TanamanRempah) t;
                                        System.out.print("  Aroma         : ");
                                        while (!tr.setAroma(sc.nextLine())) System.out.print("  Aroma         : ");
                                    } else if (t instanceof TanamanDaun) {
                                        TanamanDaun td = (TanamanDaun) t;
                                        System.out.print("  Bentuk Daun   : ");
                                        while (!td.setBentukDaun(sc.nextLine())) System.out.print("  Bentuk Daun   : ");
                                    } else if (t instanceof TanamanBuah) {
                                        TanamanBuah tb = (TanamanBuah) t;
                                        System.out.print("  Musim Berbuah : ");
                                        while (!tb.setMusimBerbuah(sc.nextLine())) System.out.print("  Musim Berbuah : ");
                                    }
                                    pesanOk("Tanaman berhasil diubah!");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }

                        } else if (sub == 4) {
                            if (daftarTanaman.isEmpty()) {
                                pesanError("Belum ada data tanaman.");
                            } else {
                                tampilPilihTanaman(daftarTanaman);
                                System.out.print("  Pilih nomor  : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarTanaman.size()) {
                                    String namaHapus = daftarTanaman.get(no - 1).getNama();
                                    daftarTanaman.remove(no - 1);
                                    daftarCatatan.removeIf(c -> c.getNamaTanaman().equals(namaHapus));
                                    pesanOk(namaHapus + " berhasil dihapus.");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }

                        } else if (sub == 5) {
                            tampilStatistik(daftarTanaman);

                        } else if (sub == 6) {
                            if (daftarTanaman.isEmpty()) {
                                pesanError("Belum ada data tanaman.");
                            } else {
                                System.out.println();
                                judulBox("PILIH TUJUAN PANEN", 30);
                                baris("1. Konsumsi (standar)", 30);
                                baris("2. Obat (senyawa maksimal)", 30);
                                baris("3. Bibit (kualitas terbaik)", 30);
                                garisTipis(30);
                                System.out.print("  Pilih (1-3) : ");
                                int pilihTujuan = sc.nextInt(); sc.nextLine();
                                String tujuan;
                                if (pilihTujuan == 2)      tujuan = "obat";
                                else if (pilihTujuan == 3) tujuan = "bibit";
                                else                       tujuan = "konsumsi";
                                tampilEstimasi(daftarTanaman, tujuan);
                            }
                        }

                    } while (sub != 0);
                    break;

                case 2:
                    int sub2;
                    do {
                        tampilMenuPengguna();
                        sub2 = sc.nextInt(); sc.nextLine();

                        if (sub2 == 1) {
                            System.out.println();
                            judulBox("TAMBAH PENGGUNA", 30);

                            String nama;
                            do {
                                System.out.print("  Nama   : ");
                                nama = sc.nextLine();
                                if (StringUtils.isBlank(nama)) {
                                    pesanError("Nama tidak boleh kosong!");
                                }
                            } while (StringUtils.isBlank(nama));

                            String alamat;
                            do {
                                System.out.print("  Alamat : ");
                                alamat = sc.nextLine();
                                if (StringUtils.isBlank(alamat)) {
                                    pesanError("Alamat tidak boleh kosong!");
                                }
                            } while (StringUtils.isBlank(alamat));

                            daftarPengguna.add(new Pengguna(nama, alamat));
                            pesanOk("Pengguna berhasil ditambahkan!");

                        } else if (sub2 == 2) {
                            if (daftarPengguna.isEmpty()) {
                                pesanError("Belum ada data pengguna.");
                            } else {
                                tampilTabelPengguna(daftarPengguna);
                            }

                        } else if (sub2 == 3) {
                            if (daftarPengguna.isEmpty()) {
                                pesanError("Belum ada data pengguna.");
                            } else {
                                tampilPilihPengguna(daftarPengguna);
                                System.out.print("  Pilih nomor : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarPengguna.size()) {
                                    Pengguna p = daftarPengguna.get(no - 1);
                                    System.out.print("  Nama   : ");
                                    while (!p.setNama(sc.nextLine()))   System.out.print("  Nama   : ");
                                    System.out.print("  Alamat : ");
                                    while (!p.setAlamat(sc.nextLine())) System.out.print("  Alamat : ");
                                    pesanOk("Pengguna berhasil diubah!");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }

                        } else if (sub2 == 4) {
                            if (daftarPengguna.isEmpty()) {
                                pesanError("Belum ada data pengguna.");
                            } else {
                                tampilPilihPengguna(daftarPengguna);
                                System.out.print("  Pilih nomor : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarPengguna.size()) {
                                    String namaHapus = daftarPengguna.get(no - 1).getNama();
                                    daftarPengguna.remove(no - 1);
                                    daftarCatatan.removeIf(c -> c.getNamaPengguna().equals(namaHapus));
                                    pesanOk(namaHapus + " berhasil dihapus.");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }
                        }

                    } while (sub2 != 0);
                    break;

                case 3:
                    int sub3;
                    do {
                        tampilMenuCatatan();
                        sub3 = sc.nextInt(); sc.nextLine();

                        if (sub3 == 1) {
                            if (daftarPengguna.isEmpty() || daftarTanaman.isEmpty()) {
                                pesanError("Pastikan data pengguna dan tanaman sudah ada terlebih dahulu.");
                            } else {
                                System.out.println();
                                judulBox("TAMBAH CATATAN", 30);
                                System.out.println("  -- Pilih Pengguna --");
                                tampilPilihPengguna(daftarPengguna);
                                int noPengguna;
                                do {
                                    System.out.print("  Pilih nomor : ");
                                    noPengguna = sc.nextInt(); sc.nextLine();
                                    if (noPengguna < 1 || noPengguna > daftarPengguna.size()) {
                                        pesanError("Nomor pengguna tidak valid!");
                                    }
                                } while (noPengguna < 1 || noPengguna > daftarPengguna.size());

                                System.out.println("  -- Pilih Tanaman --");
                                tampilPilihTanaman(daftarTanaman);
                                int noTanaman;
                                do {
                                    System.out.print("  Pilih nomor : ");
                                    noTanaman = sc.nextInt(); sc.nextLine();
                                    if (noTanaman < 1 || noTanaman > daftarTanaman.size()) {
                                        pesanError("Nomor tanaman tidak valid!");
                                    }
                                } while (noTanaman < 1 || noTanaman > daftarTanaman.size());

                                Pengguna p = daftarPengguna.get(noPengguna - 1);
                                Tanaman  t = daftarTanaman.get(noTanaman - 1);

                                String keterangan;
                                do {
                                    System.out.print("  Keterangan  : ");
                                    keterangan = sc.nextLine();
                                    if (StringUtils.isBlank(keterangan)) {
                                        pesanError("Keterangan tidak boleh kosong!");
                                    }
                                } while (StringUtils.isBlank(keterangan));

                                Catatan c = new Catatan(p.getNama(), t.getNama(), keterangan);
                                System.out.println("  >> " + c.buatRingkasan(t, p));
                                daftarCatatan.add(c);
                                pesanOk("Catatan berhasil ditambahkan!");
                            }

                        } else if (sub3 == 2) {
                            if (daftarCatatan.isEmpty()) {
                                pesanError("Belum ada data catatan.");
                            } else {
                                tampilTabelCatatan(daftarCatatan);
                            }

                        } else if (sub3 == 3) {
                            if (daftarCatatan.isEmpty()) {
                                pesanError("Belum ada data catatan.");
                            } else {
                                tampilTabelCatatan(daftarCatatan);
                                System.out.print("  Pilih nomor : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarCatatan.size()) {
                                    Catatan c = daftarCatatan.get(no - 1);
                                    System.out.print("  Keterangan baru : ");
                                    while (!c.setKeterangan(sc.nextLine())) System.out.print("  Keterangan baru : ");
                                    pesanOk("Catatan berhasil diubah!");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }

                        } else if (sub3 == 4) {
                            if (daftarCatatan.isEmpty()) {
                                pesanError("Belum ada data catatan.");
                            } else {
                                tampilTabelCatatan(daftarCatatan);
                                System.out.print("  Pilih nomor : ");
                                int no = sc.nextInt(); sc.nextLine();
                                if (no >= 1 && no <= daftarCatatan.size()) {
                                    daftarCatatan.remove(no - 1);
                                    pesanOk("Catatan berhasil dihapus.");
                                } else {
                                    pesanError("Nomor tidak valid.");
                                }
                            }
                        }

                    } while (sub3 != 0);
                    break;

                case 0:
                    break;

                default:
                    pesanError("Pilihan tidak valid.");
                    break;
            }

        } while (pilihan != 0);

        System.out.println();
        System.out.println("+================================+");
        System.out.println("|  Program selesai. Terima kasih!|");
        System.out.println("+================================+");
        sc.close();
    }
}