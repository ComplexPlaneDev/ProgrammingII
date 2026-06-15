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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node n) {
        if (n != null) {
            System.out.println(n.value);

            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);

            System.out.println(n.value);

            inOrder(n.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);

            System.out.println(n.value);
        }
    }

    private Node getSuccessor(Node n) {
        if (n != null && n.right != null) {
            n = n.right;

            while (n.left != null) {
                n = n.left;
            }
        }

        return n;
    }

    public void delNode(int v) {
        delNode(root, v);
    }

    private Node delNode(Node n, int v) {
        if (n == null) {
            return null;
        }

        if (v < n.value) {
            n.left = delNode(n.left, v);
        } else if (v > n.value) {
            n.right = delNode(n.right, v);
        } else {
            if (n.left == null && n.right == null) {
                return null;
            }

            if (n.left == null) {
                return n.right;
            }

            if (n.right == null) {
                return n.left;
            }

            Node lmr = getSuccessor(n);
            int temp = n.value;
            n.value = lmr.value;
            lmr.value = temp;

            n.right = delNode(n.right, v);
        }

        return n;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bt = new BinarySearchTree(); // BST do not allow duplicates

        /*
        bt.insert(5);
        bt.insert(1);
        bt.insert(10);
        bt.insert(7);

        System.out.println(bt.exists(5));
        System.out.println(bt.exists(8));

        bt.preOrder();
        System.out.println("----");
        bt.inOrder();
        System.out.println("----");
        bt.postOrder();
        */

        bt.insert(5);
        bt.insert(3);
        bt.insert(7);
        bt.insert(2);
        bt.insert(4);
        bt.insert(6);
        bt.insert(8);

        bt.delNode(7);
    }
}
