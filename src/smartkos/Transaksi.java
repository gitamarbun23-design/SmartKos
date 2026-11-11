
package smartkos;

import java.io.Serializable;

public class Transaksi implements Serializable {

    private String jenis;
    private String kategori;
    private double nominal;

    public Transaksi(String jenis, String kategori, double nominal) {
        this.jenis = jenis;
        this.kategori = kategori;
        this.nominal = nominal;
    }

    // Getter dan Setter
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }
}
