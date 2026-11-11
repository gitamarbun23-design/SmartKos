package smartkos;

import Pengguna.Pengguna;

public class Mahasiswa extends Pengguna {

    public Mahasiswa(String nama, String username) {
        super(nama, username);
    }

    public void tampilkanProfil() {
        System.out.println("Nama Pengguna : " + getNama());
        System.out.println("Username      : " + getUsername());
    }
}