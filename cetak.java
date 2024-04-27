import java.util.ArrayList;
import java.util.List;

public class cetak {

    public static void main(String[] args) {
        TokoBuku tokoBuku = new TokoBuku();

        Buku buku1 = new BukuKomik("Naruto", "Masashi Kishimoto", 30000);
        Buku buku2 = new BukuPelajaran("Matematika SMA", "Supriyadi", 75000);
        Buku buku3 = new BukuNovel("Laskar Pelangi", "Andrea Hirata", 45000);

        tokoBuku.tambahBuku(buku1);
        tokoBuku.tambahBuku(buku2);
        tokoBuku.tambahBuku(buku3);

        tokoBuku.tampilDaftarBuku();
        tokoBuku.cariBuku("Naruto");
        tokoBuku.hapusBuku("Matematika SMA");

        System.out.println("Total pendapatan: " + tokoBuku.hitungTotalPendapatan());
    }
}

interface Diskon {
    double hitungDiskon();
}

abstract class Buku {
    private String judul;
    private String penulis;
    private int harga;

    public Buku(String judul, String penulis, int harga) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public abstract void tampilInformasi();
}

class BukuKomik extends Buku implements Diskon {
    public BukuKomik(String judul, String penulis, int harga) {
        super(judul, penulis, harga);
    }

    @Override
    public void tampilInformasi() {
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Harga: " + getHarga());
        System.out.println("Diskon: " + hitungDiskon() + "%");
    }

    @Override
    public double hitungDiskon() {
        return 10; // Diskon 10% untuk buku komik
    }
}

class BukuPelajaran extends Buku {
    public BukuPelajaran(String judul, String penulis, int harga) {
        super(judul, penulis, harga);
    }

    @Override
    public void tampilInformasi() {
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Harga: " + getHarga());
    }
}

class BukuNovel extends Buku {
    public BukuNovel(String judul, String penulis, int harga) {
        super(judul, penulis, harga);
    }

    @Override
    public void tampilInformasi() {
        System.out.println("Judul: " + getJudul());
        System.out.println("Penulis: " + getPenulis());
        System.out.println("Harga: " + getHarga());
    }
}

class TokoBuku {
    private List<Buku> daftarBuku;

    public TokoBuku() {
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilDaftarBuku() {
        for (Buku buku : daftarBuku) {
            buku.tampilInformasi();
            System.out.println("------------------");
        }
    }

    public void cariBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                buku.tampilInformasi();
                return;
            }
        }
        System.out.println("Buku dengan judul " + judul + " tidak ditemukan");
    }

    public void hapusBuku(String judul) {
        for (int i = 0; i < daftarBuku.size(); i++) {
            if (daftarBuku.get(i).getJudul().equalsIgnoreCase(judul)) {
                daftarBuku.remove(i);
                System.out.println("Buku dengan judul " + judul + " berhasil dihapus");
                return;
            }
        }
        System.out.println("Buku dengan judul " + judul + " tidak ditemukan");
    }

    public int hitungTotalPendapatan() {
        int total = 0;
        for (Buku buku : daftarBuku) {
            total += buku.getHarga();
        }
        return total;
    }
}
