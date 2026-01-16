public class SingleLinkedList {
    Node head;

    public void insertHead(Mahasiswa data){
        long startInsert = System.nanoTime();
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        long endInsert = System.nanoTime();
        System.out.println("Insert head time: " + (endInsert - startInsert) + " ns");
    }

    public void display(){
        long startDisplay = System.nanoTime();
        Node current = head;
        int no = 1;

        if (current == null) {
            System.out.println("Data mahasiswa kosong.");
            return;
        }

        while (current != null) {
            Mahasiswa m = current.data;
            System.out.println(
                    no + ". NIM: " + m.getNim() +
                            ", Nama: " + m.getNama() +
                            ", Nilai: " + m.getNilai()
            );
            current = current.next;
            no++;
        }
        long endDisplay = System.nanoTime();
        System.out.println("Display time: " + (endDisplay - startDisplay) + " ns");
    }

    public Mahasiswa removeHead(){
        long startDelete = System.nanoTime();
        if (head == null) {
            System.out.println("Data mahasiswa kosong.");
            return null;
        }

        Mahasiswa removedData = head.data;
        head = head.next;
        long endDelete = System.nanoTime();
        System.out.println("Delete time: " + (endDelete - startDelete) + " ns");
        return removedData;
    }

    public Node search(String nim) {
        Node current = head;
        while (current != null) {
            if (current.data.getNim().equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateNilaiByNim(String nim, int nilaiBaru) {
        long startUpdate = System.nanoTime();
        Node target = search(nim);
        if (target != null) {
            target.data.setNilai(nilaiBaru);
            System.out.println("Nilai berhasil diupdate");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
        }
        long endUpdate = System.nanoTime();
        System.out.println("Update time: " + (endUpdate - startUpdate) + " ns");
    }

}
