import java.util.Scanner;

// ============================================
// ABSTRACT CLASS USER
// ============================================
abstract class User {
    protected String username;
    protected String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public abstract void interact();
    
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
    
    public String getUsername() {
        return username;
    }
}

// ============================================
// CLASS ADMIN (Child Class dari User)
// ============================================
class Admin extends User {
    protected  Book[] daftarBuku;
    protected  int jumlahBuku;
    
    public Admin(String username, String password, int kapasitasBuku) {
        super(username, password);
        this.daftarBuku = new Book[kapasitasBuku];
        this.jumlahBuku = 0;
    }
    
    @Override
    public void interact() {
        System.out.println("Admin " + username + " sedang mengelola perpustakaan");
    }
    
    // Method untuk mendapatkan buku berdasarkan ID
    public Book getBukuById(String idBuku) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIdBuku().equals(idBuku)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    public void getDaftarBuku() {
        for(int i = 0; i < daftarBuku.length ; i++) {
            System.out.println((i+1) + ". ID: " + daftarBuku[i].getIdBuku() + " | Judul: " + daftarBuku[i].getTitle() + " | Penulis: " + daftarBuku[i].getAuthor() + " | Tersedia: " + (daftarBuku[i].getIsAvailable() ? "Ya" : "Tidak"));
        }
    }
}

// ============================================
// CLASS MEMBER (Child Class dari User)
// ============================================
class Member extends User {
    private Book[] bukuDipinjam;
    private int jumlahPinjaman;
    private static final int MAKS_PINJAMAN = 3;
    
    public Member(String username, String password) {
        super(username, password);
        this.bukuDipinjam = new Book[MAKS_PINJAMAN];
        this.jumlahPinjaman = 0;
    }
    
    @Override
    public void interact() {
        System.out.println("Anggota " + username + " sedang meminjam/mengembalikan buku");
    }

    public void borrowBook(Book book) {
        if (jumlahPinjaman < MAKS_PINJAMAN && book.getIsAvailable()) {
            bukuDipinjam[jumlahPinjaman] = book;
            jumlahPinjaman++;
            book.setIsAvailable(false);
            System.out.println("Buku '" + book.getTitle() + "' berhasil dipinjam.");
        } else {
            System.out.println("Gagal meminjam buku. Batas pinjaman tercapai atau buku tidak tersedia.");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < jumlahPinjaman; i++) {
            if (bukuDipinjam[i] != null && bukuDipinjam[i].getIdBuku().equals(book.getIdBuku())) {
                bukuDipinjam[i] = null;
                jumlahPinjaman--;
                book.setIsAvailable(true);
                System.out.println("Buku '" + book.getTitle() + "' berhasil dikembalikan.");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan dalam daftar pinjaman Anda.");
    }

    public void listOfBorrowedBooks() {
        if(bukuDipinjam[0] == null) {
            System.out.println("Anda tidak memiliki buku yang dipinjam.");
            return;
        }
        for (int i = 0; i < jumlahPinjaman; i++) {
            if (bukuDipinjam[i] != null) {
                System.out.println((i+1) + ". ID: " + bukuDipinjam[i].getIdBuku() + " | Judul: "+ bukuDipinjam[i].getTitle() + " | Author:  " + bukuDipinjam[i].getAuthor());
            }
        }
    }
    
}

// ============================================
// CLASS BOOK 
// ============================================
class Book {
    private String idBuku;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String idBuku, String title, String author){
        this.idBuku = idBuku;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getter and Setter methods
    public String getIdBuku(){
        return this.idBuku;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public void setIdBuku(String title){
        this.title = title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

}
// ============================================
// MAIN CLASS - LIBRARY SYSTEM
// ============================================
public class LibraryManagement {
    private static Scanner scanner = new Scanner(System.in);
    private final static Admin admin = new Admin("admin1", "password123",  10);
    private final static Member member1 = new Member("john_doe", "password123");
    private final static Member member2 = new Member("jane_smith", "password123");


    public static void main(String[] args) {
        
        System.out.println("========================================");
        System.out.println("  SISTEM MANAJEMEN PERPUSTAKAAN SEDERHANA");
        System.out.println("========================================");
        System.out.println("Konsep OOP yang diimplementasikan:");
        System.out.println("1. Inheritance: User -> Admin & Member");
        System.out.println("2. Polymorphism: Method interact()");
        System.out.println("3. Array: Untuk menyimpan data buku");
        System.out.println("========================================\n");
        
        boolean sistemAktif = true;

         // Tambahkan data buku secara hardcode
        admin.daftarBuku = new Book[5];
        admin.daftarBuku[0] = new Book("B001", "Hujan", "Tere Liye");
        admin.daftarBuku[1] = new Book("B002", "Bumi", "Tere Liye");
        admin.daftarBuku[2] = new Book("B003", "Laut Bercerita", "Leila S. Chudori");
        admin.daftarBuku[3] = new Book("B004", "Clean Code", "Robert C. Martin");
        admin.daftarBuku[4] = new Book("B005", "Design Patterns", "Gang of Four");
        admin.jumlahBuku = 5;  // Set jumlah buku yang ditambahkan
        
        System.out.println("Data buku berhasil dimuat ke sistem.\n");
        
        while (sistemAktif) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Anggota 1 (john_doe)");
            System.out.println("3. Login sebagai Anggota 2 (jane_smith)");
            System.out.println("4. Lihat Informasi Sistem");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");
            
            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membuang newline
            } catch (Exception e) {
                System.out.println("Input tidak valid! Silakan masukkan angka.");
                scanner.nextLine();
                continue;
            }
            
            switch (pilihan) {
                case 1:
                    loginAdmin();
                    break;
                    
                case 2:
                    loginMember(member1);
                    break;
                    
                case 3:
                    loginMember(member2);
                    break;
                    
                case 4:
                    tampilkanInformasiSistem();
                    break;
                    
                case 5:
                    sistemAktif = false;
                    System.out.println("\nTerima kasih telah menggunakan sistem perpustakaan!");
                    System.out.println("Program selesai.");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.");
            }
        }
        
        scanner.close();
    }
    
    // Method untuk login admin
    private static void loginAdmin() {
        System.out.println("\n=== LOGIN ADMIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        if (admin.login(username, password)) {
            System.out.println("\nLogin berhasil! Selamat datang, Admin!");
            admin.interact(); // Demonstrasi polymorphism
            menuAdmin();
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
    
    // Method untuk login member
    private static void loginMember(Member member) {
        System.out.println("\n=== LOGIN ANGGOTA ===");
        System.out.println("Username: " + member.getUsername());
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        if (member.login(member.getUsername(), password)) {
            System.out.println("\nLogin berhasil! Selamat datang, " + member.getUsername() + "!");
            member.interact(); // Demonstrasi polymorphism
            menuMember(member);
        } else {
            System.out.println("Login gagal! Password salah.");
        }
    }
    
    // Menu Admin
    private static void menuAdmin() {
        boolean adminAktif = true;
        
        while (adminAktif) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Tambah Buku Baru");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku (berdasarkan judul)");
            System.out.println("4. Tampilkan Semua Buku");
            System.out.println("5. Tampilkan Buku yang Tersedia");
            System.out.println("6. Logout");
            System.out.print("Pilihan Anda: ");
            
            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input tidak valid! Silakan masukkan angka.");
                scanner.nextLine();
                continue;
            }
            
            switch (pilihan) {
                case 1:
                    // tambahBukuAdmin();
                    break;
                    
                case 2:
                    // hapusBukuAdmin();
                    break;
                    
                case 3:
                    // cariBukuAdmin();
                    break;
                    
                case 4:
                    // admin.tampilkanSemuaBuku();
                    break;
                    
                case 5:
                    // admin.tampilkanBukuTersedia();
                    break;
                    
                case 6:
                    // adminAktif = false;
                    // System.out.println("Logout berhasil. Kembali ke menu utama...");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-7.");
            }
        }
    }
    
    // Menu Member
    private static void menuMember(Member member) {
        boolean memberAktif = true;
        
        while (memberAktif) {
            System.out.println("\n===== MENU ANGGOTA =====");
            System.out.println("1. Pinjam Buku");
            System.out.println("2. Kembalikan Buku");
            System.out.println("3. Lihat Buku yang Tersedia");
            System.out.println("4. Lihat Buku yang Saya Pinjam");
            System.out.println("5. Cari Buku");
            System.out.println("6. Logout");
            System.out.print("Pilihan Anda: ");
            
            int pilihan = 0;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input tidak valid! Silakan masukkan angka.");
                scanner.nextLine();
                continue;
            }
            
            switch (pilihan) {
                case 1:
                    System.out.println("List buku tersedia:");
                    admin.getDaftarBuku();
                    System.out.print("Masukkan ID buku yang ingin dipinjam: ");
                    String idBuku = scanner.nextLine();
                    Book book = admin.getBukuById(idBuku);
                    if (book == null) {
                        System.out.println("Buku dengan ID tersebut tidak ditemukan.");
                        break;
                    }
                    member.borrowBook(book);
                    break;
                    
                case 2:
                    System.out.println("Buku yang Anda pinjam:");
                    member.listOfBorrowedBooks();
                    System.out.print("Masukkan ID buku yang ingin dikembalikan: ");
                    String returnIdBuku = scanner.nextLine();
                    Book returnBook = admin.getBukuById(returnIdBuku);
                    if (returnBook == null) {
                        System.out.println("Buku dengan ID tersebut tidak ditemukan.");
                        break;
                    }
                    member.returnBook(returnBook);
                    break;
                case 3:
                    System.out.println("List buku:");
                    admin.getDaftarBuku();
                    break;
                    
                case 4:
                    System.out.println("Buku yang Anda pinjam:");
                    member.listOfBorrowedBooks();
                    break;
                    
                case 5:
                    // cariBukuMember();
                    break;
                    
                case 6:
                    memberAktif = false;
                    System.out.println("Logout berhasil. Kembali ke menu utama...");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-6.");
            }
        }
    }
    
    // Method untuk menampilkan informasi sistem
    private static void tampilkanInformasiSistem() {
        System.out.println("\n=== INFORMASI SISTEM ===");
        System.out.println("\n1. KONSEP OOP YANG DIIMPLEMENTASIKAN:");
        System.out.println("   • Inheritance: Class User diwarisi oleh Admin dan Member");
        System.out.println("   • Polymorphism: Method interact() memiliki implementasi berbeda");
        System.out.println("   • Encapsulation: Atribut private dengan getter/setter public");
        System.out.println("   • Abstraction: Class User sebagai abstract class");
        
        System.out.println("\n2. STRUKTUR DATA ARRAY YANG DIGUNAKAN:");
        System.out.println("   • Array of Book: untuk menyimpan daftar buku");
        System.out.println("   • Array of Book: untuk menyimpan buku yang dipinjam anggota");
        System.out.println("   • Operasi array: tambah, hapus, cari, tampilkan");
        
        System.out.println("\n3. FITUR SISTEM:");
        System.out.println("   • Admin: tambah/hapus/cari buku");
        System.out.println("   • Anggota: pinjam/kembalikan buku, cari buku");
        System.out.println("   • Batas pinjaman: maksimal 3 buku per anggota");
        
        System.out.println("\n4. LOGIN YANG TERSEDIA:");
        System.out.println("   • Admin: username='1', password='admin123'");
        System.out.println("   • Anggota 1: username='john_doe', password='password123'");
        System.out.println("   • Anggota 2: username='jane_smith', password='password456'");
        
        System.out.print("\nTekan Enter untuk kembali ke menu utama...");
        scanner.nextLine();
    }
}