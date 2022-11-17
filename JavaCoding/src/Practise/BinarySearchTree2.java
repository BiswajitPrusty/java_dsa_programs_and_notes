package Practise;

public class BinarySearchTree2 {
    public Node root = null;


    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            root = newNode;
        } else {
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
