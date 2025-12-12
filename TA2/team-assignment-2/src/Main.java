import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList queue = new SingleLinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Sistem Antrian Restoran ===");
            System.out.println("1. Tambah antrian");
            System.out.println("2. Layani pelanggan");
            System.out.println("3. Tampilkan antrian saat ini");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nama pelanggan: ");
                    String name = scanner.nextLine();

                    System.out.print("Jumlah orang (party size): ");
                    int size = scanner.nextInt();

                    addCustomerQueue(name,size,queue);
                    break;
                case 2:
                    serveCustomer(queue);
                    break;

                case 3:
                    System.out.print("Antrian saat ini: ");
                    queue.display();
                    break;

                case 4:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 4);

        scanner.close();
    }

    static void addCustomerQueue(String nama, int partySize, SingleLinkedList queue){
        Customer customer = new Customer(nama,partySize);
        queue.push(customer);
        System.out.print("Pelanggan berhasil ditambahkan ke antrian. \nAntrian saat ini:");
        queue.display();
    }

    static void serveCustomer(SingleLinkedList queue){
        if (queue.head != null) {
            System.out.println("\nMelayani customer atas nama: " + queue.head.data.name +" untuk " + queue.head.data.partySize + " orang");
            queue.popHead();
            System.out.print("Antrian saat ini: ");
            queue.display();
        } else {
            System.out.println("Antrian kosong, tidak ada yang dilayani.");
        }
    }

}