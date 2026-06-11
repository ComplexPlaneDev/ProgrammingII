class Node {
    int value;
    Node left;
    Node right;

    Node(int v) {
        value = v;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root = null;

    public void insert(int v) {
        root = insert(root, v);
    }

    private Node insert(Node n, int v) {
        if (n == null) {
            Node newNode = new Node(v);
            return newNode;
        } else if (v < n.value) {
            n.left = insert(n.left, v);
        } else if (v > n.value) {
            n.right = insert(n.right, v);
        }

        return n;
    }

    public boolean exists(int v) {
        Node ptr = root;

        while (ptr != null) {
            if (ptr.value == v) {
                return true;
            } else if (v < ptr.value) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        return false;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bt = new BinarySearchTree(); // BST do not allow duplicates

        bt.insert(5);
        bt.insert(1);
        bt.insert(10);
        bt.insert(7);

        System.out.println(bt.exists(5));
        System.out.println(bt.exists(8));
    }
}
