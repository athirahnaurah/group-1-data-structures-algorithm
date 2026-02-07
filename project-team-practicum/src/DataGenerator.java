import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    public static Mahasiswa[] generate(int total){
        Mahasiswa[] data = new Mahasiswa[total];
        for(int i = 0; i < total; i++){
            String nim = "20" + (100000 + i);
            String nama = "Mahasiswa" + (i + 1);
            double ipk = 2.0 + (random.nextDouble() * 2.0);
            // Round 2 decimal
            ipk = Math.round(ipk * 100.0) / 100.0;
            data[i] = new Mahasiswa(nim, nama, ipk);
        }

        return data;
    }
}
