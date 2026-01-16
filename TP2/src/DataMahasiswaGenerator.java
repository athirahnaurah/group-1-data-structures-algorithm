import java.util.Random;

public class DataMahasiswaGenerator {
    private static final String[] NAMES = {"Andi", "Billy", "Citra", "Diana", "Eka", "Faisal"};
    private static final Random rand = new Random();
    private static int counter = 1000;

    public static Mahasiswa generateRandomMahasiswa() {
        String nim = "M" + counter++;  // misal M1001, M1002
        String nama = NAMES[rand.nextInt(NAMES.length)];
        int nilai = 50 + rand.nextInt(51); // nilai 50-100
        return new Mahasiswa(nim, nama, nilai);
    }
}
