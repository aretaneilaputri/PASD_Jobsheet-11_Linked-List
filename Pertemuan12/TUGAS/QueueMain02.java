package Pertemuan12.TUGAS;

import java.util.Scanner;


// Class QueueMain02
// Program utama antrian layanan unit kemahasiswaan

public class QueueMain02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue02 antrian = new Queue02(10); // kapasitas maksimal 10 orang
        int pilihan;

        // Tampilan Judul Program
        System.out.println("\n=== SISTEM ANTRIAN UNIT KEMAHASISWAAN ===");
        System.out.println("         Politeknik Negeri Malang\n");

        do {
            tampilMenu();
            System.out.print(">> Pilihan : ");
            pilihan = sc.nextInt();
            sc.nextLine();

            System.out.println();

            switch (pilihan) {

                // Tambah antrian
                case 1:
                    System.out.println("=== Form Pendaftaran Antrian ===");

                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();

                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();

                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();

                    System.out.print("IPK   : ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();

                    antrian.daftar(new MahasiswaQueue02(nim, nama, kelas, ipk));
                    break;

                // Panggil antrian
                case 2:
                    antrian.panggil();
                    break;

                // Tampilkan semua antrian
                case 3:
                    antrian.tampilSemua();
                    break;

                // Lihat antrian depan
                case 4:
                    antrian.lihatDepan();
                    break;

                // Lihat antrian belakang
                case 5:
                    antrian.lihatBelakang();
                    break;

                // Jumlah antrian
                case 6:
                    antrian.tampilJumlah();
                    break;

                // Cek status antrian
                case 7:
                    if (antrian.cekKosong()) {
                        System.out.println(">> Status : ANTRIAN KOSONG");
                    } else if (antrian.cekPenuh()) {
                        System.out.println(">> Status : ANTRIAN PENUH");
                    } else {
                        System.out.println(">> Status : Antrian berjalan normal.");
                    }

                    antrian.tampilJumlah();
                    break;

                // Kosongkan antrian
                case 8:
                    System.out.print("Konfirmasi kosongkan antrian? (y/t) : ");
                    String konfirm = sc.nextLine();

                    if (konfirm.equalsIgnoreCase("y")) {
                        antrian.kosongkanAntrian();
                    } else {
                        System.out.println("Dibatalkan.");
                    }
                    break;

                // Keluar
                case 9:
                    System.out.println("Terima kasih. Sistem antrian ditutup.");
                    break;

                default:
                    System.out.println("[!] Pilihan tidak tersedia, coba lagi.");
            }

            System.out.println();

        } while (pilihan != 9);

        sc.close();
    }

    // Method menu
    static void tampilMenu() {
        System.out.println("========================================");
        System.out.println("1. Daftar Antrian");
        System.out.println("2. Panggil Antrian");
        System.out.println("3. Tampilkan Semua Antrian");
        System.out.println("4. Lihat Antrian Terdepan");
        System.out.println("5. Lihat Antrian Paling Akhir");
        System.out.println("6. Jumlah Mahasiswa Mengantri");
        System.out.println("7. Cek Status Antrian");
        System.out.println("8. Kosongkan Antrian");
        System.out.println("9. Keluar");
        System.out.println("========================================");
    }
}