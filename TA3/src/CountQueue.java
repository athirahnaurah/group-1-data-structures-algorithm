import java.util.LinkedList;
import java.util.Queue;

public class CountQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Item 1");
        queue.add("Item 2");
        queue.add("Item 3");
        queue.add("Item 4");

        System.out.println("Isi queue: " + queue);

        // Hitung jumlah item secara manual (konsep FIFO)
        int countManual = 0;
        for (String item : queue) { // Traversal seluruh queue
            countManual++;
        }
        System.out.println("Jumlah item (manual) : " + countManual);

        // Hitung jumlah item menggunakan method bawaan size()
        int countBawaan = queue.size();
        System.out.println("Jumlah item (size()) : " + countBawaan);
    }
}
