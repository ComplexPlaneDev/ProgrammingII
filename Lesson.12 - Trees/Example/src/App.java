class Node {
    int value;
    Node left;
    Node right;
    int height;

    Node(int v) {
        value = v;
        left = right = null;
        height = 1;
    }
}

class BinarySearchTree {
    private Node root = null;

    public void insert(int v) {
        root = insert(root, v);
    }

    /* Calculate height using recursion - we don't use it here to save computation steps by consuming more memory per node
    private int height(Node n) {
        if (n == null) {
            return 0;
        }

        return 1 + Math.max(height(n.left), height(n.right));
    }
    */

    private static int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private static Node insert(Node n, int v) {
        if (n == null) {
            Node newNode = new Node(v);
            return newNode;
        } else if (v < n.value) {
            n.left = insert(n.left, v);
        } else if (v > n.value) {
            n.right = insert(n.right, v);
        }

        n.height = 1 + Math.max(height(n.left), height(n.right));

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

    private static void preOrder(Node n) {
        if (n != null) {
            System.out.println(n.value);

            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private static void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);

            System.out.println(n.value);

            inOrder(n.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private static void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);

            System.out.println(n.value);
        }
    }

    private static Node getSuccessor(Node n) {
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

    private static Node delNode(Node n, int v) {
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

    private static Node rotateRight(Node P) {
        Node D = P.left;
        Node L = D.right;

        D.right = P;
        P.left = L;

        P.height = 1 + Math.max(height(P.left), height(P.right));
        D.height = 1 + Math.max(height(D.left), height(D.right));

        return D;
    }

    private static Node rotateLeft(Node B) {
        Node D = B.right;
        Node C = D.left;

        D.left = B;
        B.right = C;

        B.height = 1 + Math.max(height(B.left), height(B.right));
        D.height = 1 + Math.max(height(D.left), height(D.right));

        return D;
    }

    private static Node balancedInsert(Node n, int v) {
        Node node = insert(n, v);

        int balanceFactor = height(node.right) - height(node.left);

        // Left-Left Case
        if (balanceFactor < -1 && v < node.left.value) {
            return rotateRight(node);
        }

        // Right-Right Case
        if (balanceFactor > 1 && v > node.right.value) {
            return rotateLeft(node);
        }

        // Left-Right Case
        if (balanceFactor < -1 && v > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right-Left Case
        if (balanceFactor > 1 && v < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void balancedInsert(int v) {
        root = balancedInsert(root, v);
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
        */

        /*
        System.out.println(bt.exists(5));
        System.out.println(bt.exists(8));

        bt.preOrder();
        System.out.println("----");
        bt.inOrder();
        System.out.println("----");
        bt.postOrder();
        */

        /*
        bt.insert(5);
        bt.insert(3);
        bt.insert(7);
        bt.insert(2);
        bt.insert(4);
        bt.insert(6);
        bt.insert(8);
        */

        // bt.delNode(7);

        /*
        // Right-Right example
        bt.balancedInsert(20);
        bt.balancedInsert(30);
        bt.balancedInsert(40);
        */

        /*
        // Left-Left example
        bt.balancedInsert(20);
        bt.balancedInsert(10);
        bt.balancedInsert(1);
        */

        /*
        // Left-Right example
        bt.balancedInsert(30);
        bt.balancedInsert(20);
        bt.balancedInsert(40);
        bt.balancedInsert(10);
        bt.balancedInsert(25);
        bt.balancedInsert(26);
        */

        /*
        // Right-Left example
        bt.balancedInsert(30);
        bt.balancedInsert(20);
        bt.balancedInsert(40);
        bt.balancedInsert(35);
        bt.balancedInsert(45);
        bt.balancedInsert(31);
        */
    }
}
