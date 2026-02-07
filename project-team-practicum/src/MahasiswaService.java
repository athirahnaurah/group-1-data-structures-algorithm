import java.util.HashMap;

public class MahasiswaService {
    private HashMap<String, Mahasiswa> map;
    private BST bst;

    public MahasiswaService(){
        map = new HashMap<>();
        bst = new BST();
    }

    // INSERT
    public void insertHash(Mahasiswa m){
        map.put(m.getNim(), m);
    }

    public void insertBST(Mahasiswa m){
        bst.insert(m);
    }

    // SEARCH DATA MAHASISWA BY NIM
    public Mahasiswa searchHash(String nim){
        return map.get(nim);
    }

    public Mahasiswa searchBST(String nim){
        return bst.search(nim);
    }

    // DELETE DATA MAHASISWA BY NIM
    public void deleteHash(String nim){
        map.remove(nim);
    }

    public void deleteBST(String nim){
        bst.delete(nim);
    }

    // DISPLAY DATA MAHASISWA
    public void displayBST(){
        bst.inorder();
    }

    // ================= PERFORMANCE =================

    public long insertHashTime(Mahasiswa m){
        return PerformanceTimer.calculate(() -> {
            insertHash(m);
        });
    }

    public long insertBSTTime(Mahasiswa m){
        return PerformanceTimer.calculate(() -> {
            insertBST(m);
        });
    }

    // SEARCH
    public TimeResult<Mahasiswa> searchHashTime(String nim){
        return PerformanceTimer.calculateWithResult(() -> {
            return searchHash(nim);
        });
    }

    public TimeResult<Mahasiswa> searchBSTTime(String nim){
        return PerformanceTimer.calculateWithResult(() -> {
            return searchBST(nim);
        });
    }

    // DELETE
    public long deleteHashTime(String nim){
        return PerformanceTimer.calculate(() -> {
            deleteHash(nim);
        });
    }

    public long deleteBSTTime(String nim){
        return PerformanceTimer.calculate(() -> {
            deleteBST(nim);
        });
    }
}
