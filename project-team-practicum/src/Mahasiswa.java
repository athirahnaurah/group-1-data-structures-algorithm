public class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;

    // Constructor Mahasiswa
    public Mahasiswa(String nim, String nama, double ipk){
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    // Setter dan Getter
    public String getNim(){
        return nim;
    }

    public String getNama(){
        return nama;
    }

    public double getIpk(){
        return ipk;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setIpk(double ipk){
        this.ipk = ipk;
    }
}
