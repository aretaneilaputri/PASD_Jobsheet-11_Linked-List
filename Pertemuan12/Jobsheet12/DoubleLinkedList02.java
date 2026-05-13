package Pertemuan12.Jobsheet12;

public class DoubleLinkedList02 {
    Node02 head;
    Node02 tail;

    public DoubleLinkedList02() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa02 data) {
        Node02 newNode02 = new Node02(data);
        if (isEmpty()) {
            head = tail = newNode02;
        } else {
            newNode02.next = head;
            head.prev = newNode02;
            head = newNode02;
        }
    }

    public void addLast(Mahasiswa02 data) {
        Node02 newNode02 = new Node02(data);
        if (isEmpty()) {
            head = tail = newNode02;
        } else {
            tail.next = newNode02;
            newNode02.prev = tail;
            tail = newNode02;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa02 data) {
        Node02 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node02 newNode02 = new Node02(data);

        // Jika current adalah tail, node baru ditambahkan di akhir
        if (current == tail) {
            newNode02.prev = current;
            current.next = newNode02;
            tail = newNode02;
        } else { // node baru disisipkan di tengah
            newNode02.prev = current;
            newNode02.next = current.next;
            current.next.prev = newNode02;
            current.next = newNode02;
        }

        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }

        Node02 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }


public void printRreverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }
        System.out.println("Data dari belakang ke depan:");
        Node02 current = tail;
        while (current != null) {
            current.data.tampil();
            current = current.prev;  
        }
    }
}


