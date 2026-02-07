public class BST {
    Node root;

    public BST(){
        this.root = null;
    }

    public void insert(Mahasiswa data){
        this.root = insertRecursive(root,data);
    }

    private Node insertRecursive(Node root, Mahasiswa data){
        if(root == null){
            return new Node(data);
        }

        if(data.getNim().compareTo(root.data.getNim()) < 0){
            root.left = insertRecursive(root.left,data);
        } else if (data.getNim().compareTo(root.data.getNim()) > 0) {
            root.right = insertRecursive(root.right,data);
        }

        return root;
    }

    public Mahasiswa search(String nim) {
        return searchRecursive(root, nim);
    }

    private Mahasiswa searchRecursive(Node root, String nim) {
        if(root == null) return null;
        if(nim.equals(root.data.getNim())) return root.data;

        return nim.compareTo(root.data.getNim()) < 0 ? searchRecursive(root.left, nim) : searchRecursive(root.right, nim);
    }
    public void delete(String nim) {
        root = deleteRecursive(root, nim);
    }

    private Node deleteRecursive(Node root, String nim) {
        if (root == null) return root;

        if (nim.compareTo(root.data.getNim()) < 0) {
            root.left = deleteRecursive(root.left, nim);
        } else if (nim.compareTo(root.data.getNim()) > 0) {
            root.right = deleteRecursive(root.right, nim);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = findMinimumRecursive(root.right);
            root.right = deleteRecursive(root.right, root.data.getNim());
        }
        return root;
    }

    private Mahasiswa findMinimumRecursive(Node root){
        if(root == null){
            System.out.println("Tree is empty");
            return null;
        }

        if(root.left == null){
            return root.data;
        }

        return findMinimumRecursive(root.left);
    }

    public void inorder(){
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node root){
        if(root != null){
            inorderRecursive(root.left);
            System.out.printf(
                    "%-10s | %-20s | %.2f%n",
                    root.data.getNim(),
                    root.data.getNama(),
                    root.data.getIpk()
            );
            inorderRecursive(root.right);
        }
    }
}
