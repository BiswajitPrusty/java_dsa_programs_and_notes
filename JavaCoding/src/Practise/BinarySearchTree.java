package Practise;

public class BinarySearchTree {
    Node root = null;


    //lookup function

    public boolean lookup(int value) {
        Node current = this.root;
        while (current != null) {
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    //insert value into tree
    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = this.root;
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

