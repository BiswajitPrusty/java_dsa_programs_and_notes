package Practise;

public class Date2708 {

    public static void main(String[] args) {
    Date2708 d = new Date2708();
//    d.mergingArray();
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(9);
    bst.insert(20);
    bst.insert(4);
    bst.insert(1);
    bst.insert(6);
    bst.insert(15);
    bst.insert(170);
    boolean b = bst.lookup(9);
        System.out.println(b);
    }

    public void mergingArray() {
        int a1[] = {0, 3, 4, 31};
        int a2[] = {4, 6, 30};
        int a[] = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                a[k] = a1[i];
                k++;
                i++;
            } else {
                a[k] = a2[j];
                k++;
                j++;
            }
        }
        while (i < a1.length) {
            a[k++]=a1[i++];
        }
        while (j< a2.length){
            a[k++] = a2[j++];
        }
        for (int abc : a) {
            System.out.print(abc + " ");
        }
    }
}
