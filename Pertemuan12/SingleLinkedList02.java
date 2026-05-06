package Pertemuan12;

import java.util.Scanner;

public class SingleLinkedList02 {

    NodeMahasiswa02 head;
    NodeMahasiswa02 tail;

    
    boolean isEmpty() {
        return (head == null);
    }

    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa02 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println();
        } else {
            System.out.println("Linked list kosong");
        }
    }

    
    public void addFirst(Mahasiswa02 input) {
        NodeMahasiswa02 ndInput = new NodeMahasiswa02(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    
    public void addLast(Mahasiswa02 input) {
        NodeMahasiswa02 ndInput = new NodeMahasiswa02(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    
    public void insertAfter(String key, Mahasiswa02 input) {
        NodeMahasiswa02 ndInput = new NodeMahasiswa02(input, null);
        NodeMahasiswa02 temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    
    public void insertAt(int index, Mahasiswa02 input) {
        if (index < 0) {
            System.out.println("indeks salah");
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa02 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new NodeMahasiswa02(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }


 public void addFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa : ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= jumlah; i++) {
            System.out.println("--- Data Mahasiswa ke-" + i + " ---");
            System.out.print("Masukkan NIM    : ");
            String nim = sc.nextLine();
            System.out.print("Masukkan Nama   : ");
            String nama = sc.nextLine();
            System.out.print("Masukkan Kelas  : ");
            String kelas = sc.nextLine();
            System.out.print("Masukkan IPK    : ");
            double ipk = sc.nextDouble();
            sc.nextLine();
            Mahasiswa02 mhs = new Mahasiswa02(nim, nama, kelas, ipk);
            addLast(mhs);
            System.out.println("Data berhasil ditambahkan.\n");
        }
    }
}