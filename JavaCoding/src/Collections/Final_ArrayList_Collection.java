package Collections;


import java.util.*;
import java.util.stream.Collectors;

 class Final_ArrayList_Collection {
    public static void main(String args[]) {
        //create an ArrayList
        ArrayList<String> city_List = new ArrayList<String>();
        //add elements to the ArrayList using add method
        System.out.println("*************************************************");
        System.out.println("Add Method");
        city_List.add("Delhi");
        city_List.add("Mumbai");
        city_List.add("Chennai");
        city_List.add("Kolkata");
        //print the list
        System.out.println("Initial ArrayList:" + city_List);

        System.out.println("*************************************************");
        System.out.println("AddAll Method");
        //define a second list
        ArrayList<String> more_Cities = new ArrayList<String>(Arrays.asList("Pune", "Hyderabad"));
        //use addAll method to add the list to ArrayList at index 4
        city_List.addAll(4, more_Cities);
        //print the list
        System.out.println("ArrayList after adding list at index 4:" + city_List);

        System.out.println("*************************************************");
        System.out.println("Remove Method");
        System.out.println("Original List:" + city_List);
        //remove element at index 2
        city_List.remove(2);
        //print the list
        System.out.println("ArrayList after removing element at index 2:" + city_List);
        //remove the element "Kolkata"
        city_List.remove("Kolkata");
        //print the list
        System.out.println("ArrayList after removing element -> Kolkata:" + city_List);


        System.out.println("*************************************************");
        System.out.println("Sort Method");
        System.out.println("ArrayList Before call to sorting:" + city_List);
        Collections.sort(city_List);
        System.out.println("ArrayList after call to sorting:" + city_List);

        System.out.println("*************************************************");
        System.out.println("Get and Set Method");
        System.out.println("Original ArrayList" + city_List);
        System.out.println("Entry at index 1 before call to set: " + city_List.get(1));
        //replace the value at index 2 with new value
        city_List.set(1, "Yellow");
        //print the value at index 2 again
        System.out.println("Entry at index 1 after call to set: " + city_List.get(1));
        System.out.println("After set ArrayList" + city_List);


        System.out.println("*************************************************");
        System.out.println("Reverse Method");
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(2);
        intList.add(3);
        intList.add(5);
        intList.add(3);
        intList.add(2);
        intList.add(1);
        intList.add(1);
        //Reverse
        System.out.print("Initial ArrayList: " + intList);
        Collections.reverse(intList);
        //print the ArrayList
        System.out.print("\nReversed ArrayList: " + intList);

        System.out.println("\n*************************************************");
        System.out.println("contains Method");
        //contains
        System.out.println("contains: " + city_List.contains("Pune"));


        System.out.println("*************************************************");
        System.out.println("IsEmpty Method");
        //empty
        System.out.println("isEmpty: " + city_List.isEmpty());


        System.out.println("*************************************************");
        System.out.println("Iterator Method");
        //use iterator() method to traverse through the list
        System.out.println("List contents using Iterator () method:");
        Iterator iter = city_List.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        //use listIterator() method to traverse through the list
        System.out.println("\nList contents using listIterator () method:");
        ListIterator<String> list_iter = city_List.listIterator();
        while (list_iter.hasNext()) {
            System.out.print(list_iter.next() + " ");
        }

        System.out.println("\n*************************************************");
        System.out.println("Shuffle Method");
        //shuffle
        System.out.println("Original ArrayList : " + city_List);
        //shuffle the ArrayList without random function
        Collections.shuffle(city_List);
        System.out.println("Shuffled ArrayList without Random() :" + city_List);
        // shuffle the ArrayList with random() function
        Collections.shuffle(city_List, new Random());
        System.out.println("Shuffled ArrayList with Random(1) : " + city_List);
        // use random (2) to shuffle the ArrayList
        Collections.shuffle(city_List, new Random(2));
        System.out.println("Shuffled ArrayList with Random(2) :" + city_List);


        System.out.println("\n*************************************************");
        System.out.println("IndexOf and LastIndexOf Method");
        System.out.println("The ArrayList: " + intList);
        //call indexOf() and lastIndexOf() methods to check the indices of specified elements
        System.out.println("indexOf(1) : " + intList.indexOf(1));
        System.out.println("lastIndexOf(1) : " + intList.lastIndexOf(1));
        System.out.println("indexOf(2) : " + intList.indexOf(2));
        System.out.println("lastIndexOf(2) : " + intList.lastIndexOf(2));

        System.out.println("\n*************************************************");
        System.out.println("Toarray Method");
        System.out.println("ArrayList: " + intList);
        //declare array
        Integer myArray[] = new Integer[intList.size()];
        //use toArray method to convert ArrayList to Array
        myArray = intList.toArray(myArray);
        //print the Array
        System.out.println("Array from ArrayList:" + Arrays.toString(myArray));

        System.out.println("\n*************************************************");
        System.out.println("Clone Method");
        System.out.println("Original ArrayList: " + city_List);
        ArrayList<String> clone_list = (ArrayList<String>) city_List.clone();
        System.out.println("Cloned ArrayList: " + clone_list);
        //add one elmeent & remove one element from original arraylist
        city_List.add("Mango");
        //print original and cloned ArrayList again
        System.out.println("Original ArrayList after add" + city_List);
        System.out.println("Cloned ArrayList after original changed:" + clone_list);

        System.out.println("\n*************************************************");
        System.out.println("Sublist Method");
        System.out.println("Original ArrayList: " + intList);
        //create a sublist for the given ArrayList
        ArrayList<Integer> sub_ArrayList = new ArrayList<Integer>(intList.subList(2, 6));
        //print the sublist
        System.out.println("Sublist of given ArrayList: " + sub_ArrayList);

        System.out.println("\n*************************************************");
        System.out.println("Remove Duplicates Method");
        ArrayList<Integer> numList = new ArrayList<>
                (Arrays.asList(1, 2, 3, 1, 3, 5, 5, 6, 6, 7, 7, 8, 8));
        //print the original ArrayList
        System.out.println("Original ArrayList:" + numList);
        //Use Java 8 stream().distinct()  method to remove duplicates from the list
        List<Integer> distinctList = numList.stream().distinct().collect(Collectors.toList());
        //print the new list
        System.out.println("ArrayList without duplicates:" + distinctList);


        System.out.println("\n*************************************************");
        System.out.println("RetainAll Method");
        System.out.println("Original ArrayList:" + city_List);
        //define another collection
        ArrayList<String> color_collection = new ArrayList<String>();
        color_collection.add("Mumbai");
        color_collection.add("Pune");
        System.out.println("Collection elements to be retained in the list:" + color_collection);
        //call retainAll method with above collection as an argument
        city_List.retainAll(color_collection);
        //print the ArrayList after retainAll call.
        System.out.println("ArrayList after retainAll call:" + city_List);

        System.out.println("\n*************************************************");
        System.out.println("RemoveAll Method");
        city_List.add("Delhi");
        city_List.add("Mumbai");
        city_List.add("Chennai");
        city_List.add("Kolkata");
        System.out.println("Original ArrayList" + city_List);
        city_List.removeAll(city_List);
        //print the list
        System.out.println("ArrayList after call to removeAll:" + city_List);

        System.out.println("\n*************************************************");
        System.out.println("Size and clear Method");
        city_List.add("Delhi");
        city_List.add("Mumbai");
        city_List.add("Chennai");
        city_List.add("Kolkata");
        System.out.println("size, before clearing: " + city_List.size());
        city_List.clear();//clearing array
        System.out.println("size, after clearing: " + city_List.size());
    }
}
