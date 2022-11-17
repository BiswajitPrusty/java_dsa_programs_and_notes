package Practise;

public class Date2908 {
    Node node;

    public static void main(String[] args) {
        Date2908 d = new Date2908();
        d.node = new Node(1);
        d.node.left = new Node(2);
        d.node.right = new Node(3);
        d.node.left.left = new Node(4);
        d.node.left.right = new Node(5);
        d.node.right.left = new Node(6);
        d.node.right.right = new Node(7);

        d.postOrder(d.node);

    }


    public void postOrder(Node obj) {
        if (obj == null)
            return;
        postOrder(obj.left);
        postOrder(obj.right);
        System.out.print(obj.value + ", ");
    }

    public void preOrder(Node obj) {
        if (obj == null)
            return;
        System.out.print(obj.value + ", ");
        preOrder(obj.left);
        preOrder(obj.right);
    }

    public void inOrder(Node obj) {
        if (obj == null)
            return;
        inOrder(obj.left);
        System.out.print(obj.value + ", ");
        inOrder(obj.right);
    }
}
