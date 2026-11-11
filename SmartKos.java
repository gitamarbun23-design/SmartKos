
package smartkos;

import Pengguna.Pengguna;
import java.util.*;
import java.io.*;

public class SmartKos {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Transaksi> daftar = new ArrayList<>();

    static final String FILE = "data_smartkos.dat";

    // Menyimpan data transaksi
    static void simpanData() {
        try {
            ObjectOutputStream output =
                new ObjectOutputStream(
                    new FileOutputStream(FILE)
                );

            output.writeObject(daftar);
            output.close();

            System.out.println("Data berhasil disimpan!");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    // Membaca data transaksi
    static void muatData() {
        try {
            ObjectInputStream file =
                new ObjectInputStream(
                    new FileInputStream(FILE)
                );

            daftar = (ArrayList<Transaksi>) file.readObject();
            file.close();

            System.out.println("Data sebelumnya berhasil dimuat!");

        } catch (FileNotFoundException e) {
            System.out.println("Belum ada data tersimpan.");

        } catch (Exception e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }
    }

    // Menambahkan pemasukan atau pengeluaran
    static void tambahTransaksi(String jenis) {

        System.out.print("Masukkan kategori: ");
        String kategori = input.nextLine();

        System.out.print("Masukkan nominal: Rp");

        try {
            double nominal = Double.parseDouble(input.nextLine());

            if (nominal <= 0) {
                System.out.println("Nominal harus lebih dari 0!");
                return;
            }

            Transaksi transaksi =
                new Transaksi(jenis, kategori, nominal);

            daftar.add(transaksi);

            simpanData();

            System.out.println("Transaksi berhasil ditambahkan!");

        } catch (NumberFormatException e) {
            System.out.println("Nominal harus berupa angka!");
        }
    }

    // Menampilkan riwayat transaksi
    static void tampilkanTransaksi() {

        if (daftar.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n===== RIWAYAT TRANSAKSI =====");

        for (int i = 0; i < daftar.size(); i++) {

            Transaksi t = daftar.get(i);

            System.out.println("\nTransaksi ke-" + (i + 1));
            System.out.println("Jenis    : " + t.getJenis());
            System.out.println("Kategori : " + t.getKategori());
            System.out.println("Nominal  : Rp" + t.getNominal());
        }
    }

    // Menghitung saldo
    static void tampilkanSaldo() {

        double pemasukan = 0;
        double pengeluaran = 0;

        for (Transaksi t : daftar) {

            if (t.getJenis().equals("Pemasukan")) {
                pemasukan += t.getNominal();

            } else {
                pengeluaran += t.getNominal();
            }
        }

        System.out.println("\n===== RINGKASAN KEUANGAN =====");
        System.out.println("Total Pemasukan   : Rp" + pemasukan);
        System.out.println("Total Pengeluaran : Rp" + pengeluaran);
        System.out.println("Saldo Akhir       : Rp" +
            (pemasukan - pengeluaran));
    }

    public static void main(String[] args) {

        muatData();

        System.out.println("\n================================");
        System.out.println("       SMARTKOS APPLICATION");
        System.out.println("          SMART ECONOMY");
        System.out.println("================================");

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan username: ");
        String username = input.nextLine();

        Mahasiswa pengguna = new Mahasiswa(nama, username);

        System.out.println("\nSelamat datang di SmartKos!");
        pengguna.tampilkanProfil();

        int pilihan = 0;

        do {
            System.out.println("\n===== MENU SMARTKOS =====");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Riwayat Transaksi");
            System.out.println("4. Lihat Saldo");
            System.out.println("5. Simpan Data");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {

                    case 1:
                        tambahTransaksi("Pemasukan");
                        break;

                    case 2:
                        tambahTransaksi("Pengeluaran");
                        break;

                    case 3:
                        tampilkanTransaksi();
                        break;

                    case 4:
                        tampilkanSaldo();
                        break;

                    case 5:
                        simpanData();
                        break;

                    case 6:
                        simpanData();
                        System.out.println("Terima kasih telah menggunakan SmartKos!");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Masukkan pilihan berupa angka!");
            }

        } while (pilihan != 6);

        input.close();
    }
}
