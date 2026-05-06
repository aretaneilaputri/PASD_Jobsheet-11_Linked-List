package Pertemuan12;

public class SLLMain02 {
    public static void main(String[] args) {

        SingleLinkedList02 sll = new SingleLinkedList02();

        Mahasiswa02 mhs1 = new Mahasiswa02("24212200", "Alvaro", "1A", 4.0);
        Mahasiswa02 mhs2 = new Mahasiswa02("22212202", "Cintia", "3C", 3.5);
        Mahasiswa02 mhs3 = new Mahasiswa02("23212201", "Bimon",  "2B", 3.8);
        Mahasiswa02 mhs4 = new Mahasiswa02("21212203", "Dirga",  "4D", 3.6);

       sll.addFirst(mhs4);         
       sll.addLast(mhs1);          
       sll.insertAfter("Dirga", mhs2);
       sll.insertAt(2, mhs3);          
        
        System.out.println("Kondisi awal: ");
        sll.print();

        
        System.out.println("data index 1 : ");
        sll.getData(1);

        System.out.println("data mahasiswa an Bimon berada pada index : " + sll.indexOf("bimon"));
        System.out.println();

        sll.removeFirst();
        sll.removeLast();
        sll.print();
        sll.removeAt(0);
        sll.print();
    }
}