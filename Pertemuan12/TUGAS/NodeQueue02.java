package Pertemuan12.TUGAS;
 
public class NodeQueue02 {
 
    MahasiswaQueue02 data;   // data yang disimpan
    NodeQueue02 next;        // pointer ke node selanjutnya
 
    public NodeQueue02(MahasiswaQueue02 data, NodeQueue02 next) {
        this.data = data;
        this.next = next;
    }
}