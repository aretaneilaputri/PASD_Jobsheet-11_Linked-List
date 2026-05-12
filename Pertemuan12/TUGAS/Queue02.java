package Pertemuan12.TUGAS;
 

// Class Queue02
// Implementasi antrian berbasis Linked List
// Prinsip FIFO : masuk dari belakang (rear), keluar dari depan (front)

public class Queue02 {
 
    NodeQueue02 front;   // node paling depan - yang pertama dipanggil
    NodeQueue02 rear;    // node paling belakang - yang terakhir masuk
    int jumlah;          // jumlah mahasiswa yang sedang mengantri
    int kapasitas;       // batas maksimal antrian
 
    // Constructor - inisialisasi antrian kosong
    public Queue02(int maks) {
        this.kapasitas = maks;
        this.jumlah    = 0;
        this.front     = null;
        this.rear      = null;
    }
 
    
    // (d) CEK ANTRIAN KOSONG
    // Return true jika tidak ada mahasiswa yang mengantri
    
    public boolean cekKosong() {
        return jumlah == 0;
    }
 
    
    // (d) CEK ANTRIAN PENUH
    // Return true jika jumlah antrian sudah mencapai kapasitas
    
    public boolean cekPenuh() {
        return jumlah == kapasitas;
    }
 
    
    // (d) MENGOSONGKAN ANTRIAN
    // Reset semua pointer dan counter ke kondisi awal
    
    public void kosongkanAntrian() {
        front  = null;
        rear   = null;
        jumlah = 0;
        System.out.println("[INFO] Semua antrian telah dihapus.");
    }
 
    
    // (e) ENQUEUE - Mendaftarkan mahasiswa ke antrian
    // Node baru selalu masuk dari posisi REAR (belakang)
    
    public void daftar(MahasiswaQueue02 mhs) {
        if (cekPenuh()) {
            System.out.println("[!] Antrian sudah penuh, " + mhs.nama + " tidak bisa masuk.");
            return;
        }
        NodeQueue02 nodeBaru = new NodeQueue02(mhs, null);
        if (cekKosong()) {
            front = nodeBaru;
            rear  = nodeBaru;
        } else {
            rear.next = nodeBaru;   // sambungkan rear lama ke node baru
            rear      = nodeBaru;   // geser rear ke node baru
        }
        jumlah++;
        System.out.printf("[+] %-20s berhasil masuk antrian. (Antrian ke-%d)%n",
                          mhs.nama, jumlah);
    }
 
    
    // (f) DEQUEUE - Memanggil mahasiswa terdepan untuk dilayani
    // Node yang keluar selalu dari posisi FRONT (depan)
    
    public void panggil() {
        if (cekKosong()) {
            System.out.println("[!] Tidak ada mahasiswa dalam antrian.");
            return;
        }
        MahasiswaQueue02 dilayani = front.data;
        front = front.next;
        if (front == null) rear = null;   // kalau antrian jadi kosong, reset rear
        jumlah--;
 
        System.out.println("\n=== Mahasiswa Dipanggil ===");
        dilayani.tampilInformasi();
        System.out.println("Sisa antrian : " + jumlah + " mahasiswa");
    }
 
    
    // (g) LIHAT ANTRIAN TERDEPAN tanpa menghapus
    
    public void lihatDepan() {
        if (cekKosong()) {
            System.out.println("[INFO] Antrian sedang kosong.");
            return;
        }
        System.out.println("\n=== Antrian Terdepan ===");
        front.data.tampilInformasi();
    }
 
    
    // (g) LIHAT ANTRIAN PALING AKHIR tanpa menghapus
    
    public void lihatBelakang() {
        if (cekKosong()) {
            System.out.println("[INFO] Antrian sedang kosong.");
            return;
        }
        System.out.println("\n=== Antrian Paling Akhir ===");
        rear.data.tampilInformasi();
    }
 
    
    // (h) TAMPILKAN JUMLAH mahasiswa yang masih mengantri
   
    public void tampilJumlah() {
        System.out.println(">> Total mahasiswa mengantri : " + jumlah + " / " + kapasitas + " orang");
    }
 
    
    // TAMPILKAN SELURUH ISI ANTRIAN (bonus - untuk menu 3)
    // tmp menelusuri dari front ke rear tanpa mengubah posisi front
    
    public void tampilSemua() {
        if (cekKosong()) {
            System.out.println("[INFO] Antrian sedang kosong.");
            return;
        }
        System.out.println("\n=====- ISI ANTRIAN -=====");
        NodeQueue02 tmp = front;   // tmp untuk traversal, front tidak bergeser
        int no = 1;
        while (tmp != null) {
            System.out.println("Antrian ke-" + no + ": ");
            tmp.data.tampilInformasi();
            tmp = tmp.next;
            no++;
        }
        System.out.println("================================");
        tampilJumlah();
    }
}