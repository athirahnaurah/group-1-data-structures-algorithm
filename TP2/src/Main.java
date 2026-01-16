import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();
        int pilihan;

        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa (Insert at Head)");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Update Nilai Mahasiswa (by NIM)");
            System.out.println("4. Hapus Data Mahasiswa (Remove head)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    Mahasiswa dataMhs2 = DataMahasiswaGenerator.generateRandomMahasiswa();
                    list.insertHead(dataMhs2);
                    System.out.println("Mahasiswa " + dataMhs2.getNim() +"-" + dataMhs2.getNama() +" berhasil ditambahkan.");
                    break;

                case 2:
                    System.out.println("\nDaftar Mahasiswa:");
                    list.display();
                    break;

                case 3:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nimUpdate = sc.nextLine();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = sc.nextInt();
                    sc.nextLine();

                    list.updateNilaiByNim(nimUpdate, nilaiBaru);
                    break;

                case 4:
                    System.out.println("Menghapus Data Pertama Mahasiswa ");
                    Mahasiswa deletedMahasiswa = list.removeHead();
                    System.out.println("Data Mahasiswa "+ deletedMahasiswa.getNim() + "-"+deletedMahasiswa.getNama() +" berhasil dihapus");
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        sc.close();
    }
}
