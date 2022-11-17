package DataStructure;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        head = new Node(value);
        tail = head;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("length dek bhai phele");
        } else if (index == 0)
            prepend(value);
        else if (index == length)
            append(value);
        else {
            Node current = head;
            for (int i = 0; i < index-1 ; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }


    public void remove(int index) {

        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("kya re length dek");
        } else if (index == 0) {
            head = this.head.next;
            length--;
        } else {
            Node current = head;
            int i;
            for (i = 0; i < index -1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            }
        }

    }

    public LinkedList reverse(LinkedList linkedList) {
        LinkedList newList = new LinkedList(linkedList.head.value);
        Node current = linkedList.head;
        while (current.next != null) {
            current = current.next;
            Node newNode = new Node(current.value);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }


    public void printList() {
        Node check = this.head;
        while (check != null) {
            System.out.print(check.value + " ");
            check = check.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList(10);
        l.append(11);
        l.append(12);
        l.prepend(9);
        l.insert(   1,2);
        l.printList();

    }

}
