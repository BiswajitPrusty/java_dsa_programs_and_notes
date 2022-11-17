package DataStructure;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(10);
        b.insert(5);
        b.insert(12);
        System.out.println(b.lookup(1));

    }

    public Node root = null;

    public boolean lookup(int value) {
        Node current = root;
        while (current != null) {
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            } else if (current.value == value) {
                return true;
            }
        }
        return false;
    }

    public void insert(int value) {

        Node newNode = new Node(value);
        if (this.root == null)
            root = newNode;
        else {
            Node current = root;
            while (true) {

                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                }
            }
        }
    }

}
