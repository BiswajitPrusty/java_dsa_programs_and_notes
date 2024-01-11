package questions.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberStudentsUnableEatLunch1700 {

    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1}, sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(countStudents(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        for (int student : students) {
            studentsQueue.add(student);
        }

        int top = 0;
        int countLoops = 0;
        while (!studentsQueue.isEmpty()) {
            if (studentsQueue.peek() == sandwiches[top]) {
                studentsQueue.poll();
                top++;
                countLoops = 0;
            } else {
                studentsQueue.add(studentsQueue.poll());
                countLoops++;
            }

            if (countLoops == 2 * students.length) return studentsQueue.size();
        }

        return studentsQueue.size();
    }


    public int countStudents2(int[] students, int[] sandwiches) {
        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0

        for(int stud : students){
            if(stud == 0) zeros++;
            else ones++;
        }

        // for each sandwich in sandwiches
        for(int sandwich : sandwiches){
            if(sandwich == 0){  // if sandwich is of type0
                if(zeros == 0){ // if no student want a type0 sandwich
                    return ones;
                }
                zeros--;
            }
            else{  // if sandwich is of type1
                if(ones == 0){  // if no student want a type1 sandwich
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}
