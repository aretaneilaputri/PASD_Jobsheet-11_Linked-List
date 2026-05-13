package Pertemuan12.Jobsheet12;

import java.util.Scanner;

public class DoubleLinkedListMain02 {

    public static Mahasiswa02 inputMahasiswa02(Scanner scan) {
        System.out.print("Masukkan NIM      : ");
        String nim = scan.nextLine();

        System.out.print("Masukkan Nama     : ");
        String nama = scan.nextLine();

        System.out.print("Masukkan kelas    : ");
        String kelas = scan.nextLine();

        System.out.print("Masukkan IPK      : ");
        double ipk = scan.nextDouble();
        scan.nextLine();

        return new Mahasiswa02(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoubleLinkedList02 list = new DoubleLinkedList02();
        int pilihan;

        do {
            System.out.println("\n----- MENU DOUBLE LINKED LIST -----");
            System.out.println("1. Tambah data di awal");
            System.out.println("2. Tambah data di akhir");
            System.out.println("3. Sisipkan data di tengah (setelah NIM)");
            System.out.println("4. Hapus data di awal");
            System.out.println("5. Hapus data di akhir");
            System.out.println("6. Tampilkan data");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    list.addFirst(inputMahasiswa02(scan));
                    break;

                case 2:
                    list.addLast(inputMahasiswa02(scan));
                    break;

                case 3:
                    System.out.print("Masukkan NIM yang dicari : ");
                    String keyNim = scan.nextLine();

                    System.out.println("Masukkan data baru : ");
                    Mahasiswa02 dataBaru = inputMahasiswa02(scan);

                    list.insertAfter(keyNim, dataBaru);
                    break;

                case 6:
                    list.print();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
            }

        } while (pilihan != 0);

        scan.close();
    }
}