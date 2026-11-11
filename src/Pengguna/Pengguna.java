package Pengguna;

import java.io.Serializable;

public class Pengguna implements Serializable {

    private String nama;
    private String username;

    public Pengguna(String nama, String username) {
        this.nama = nama;
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}