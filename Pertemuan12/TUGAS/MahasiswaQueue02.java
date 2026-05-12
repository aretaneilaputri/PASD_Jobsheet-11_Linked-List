package Pertemuan12.TUGAS;
 
public class MahasiswaQueue02 {
 
    String nim;
    String nama;
    String kelas;
    double ipk;
 
    // Constructor default
    public MahasiswaQueue02() {}
 
    // Constructor berparameter - langsung isi semua data
    public MahasiswaQueue02(String nm, String name, String kls, double ip) {
        this.nim   = nm;
        this.nama  = name;
        this.kelas = kls;
        this.ipk   = ip;
    }
 
    // Menampilkan data mahasiswa dalam format tabel
    public void tampilInformasi() {
        System.out.printf("  Nama  : %s%n", nama);
        System.out.printf("  NIM   : %s%n", nim);
        System.out.printf("  Kelas : %s%n", kelas);
        System.out.printf("  IPK   : %.1f%n", ipk);
    }
}