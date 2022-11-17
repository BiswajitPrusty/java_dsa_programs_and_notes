package Practise;

public class Bst {

    public Node root = null;

    public static void main(String[] args) {
        Bst b = new Bst();
        b.insert(10);
        b.insert(5);
        b.insert(12);
        b.insert(54);
        System.out.println(b.lookup(45));
        b.inorder(b.root);

    }

    public void inorder(Node current) {

        if (current == null) {
            return;
        }
        inorder(current.left);
        System.out.print(current.value+", ");
        inorder(current.right);
    }

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
        Node node = new Node(value);

        if (this.root == null) {
            root = node;
        } else {
            Node current = root;
            while (true) {
                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = node;
                        break;
                    }
                } else {
                    if (current.left != null)
                        current = current.left;
                    else {
                        current.left = node;
                        break;
                    }
                }
            }
        }

    }
}


