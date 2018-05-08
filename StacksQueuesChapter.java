import java.util.*;

public class StacksQueuesChapter {

    public static void maxSort(Stack s1, Stack s2, int index) {
        int max = (int)s1.pop();
        if(s1.isEmpty()) {System.out.println("maxSort s1 is empty");}
        while(!s1.isEmpty()){
            if((int)s1.peek() > max){
                s2.push(max);
                max = (int)s1.pop();
            } else {
                int temp = (int)s1.pop();
                s2.push(temp);
            }
        }
        s2.push(max);
        index++;
        if(index<s2.size()/2) {
            minSort(s2, s1, index);
        }
    }
    public static void minSort(Stack s1, Stack s2, int index) {
        int min = (int)s1.pop();
        while(!s1.isEmpty()){

            if((int)s1.peek() < min){
                s2.push(min);
                min = (int)s1.pop();
            } else {
                int temp = (int)s1.pop();
                s2.push(temp);
            }
        }
        s2.push(min);
        index++;
        if(index<s2.size()/2) {
            maxSort(s2, s1, index);
        }
    }
    public static Stack sortStack(Stack s1) {
        Stack<Integer> s2 = new Stack<Integer>();
        int index = 0;
        maxSort(s1, s2, index);
        if(s1.isEmpty()) {
            return s2;
        }
        return s1;
    }

    public static void main (String[] args) {
//        LinkedListOfStacks stackOfPlates = new LinkedListOfStacks();
//        stackOfPlates.push(10);
//        stackOfPlates.push(2);
//        stackOfPlates.push(1);
//        stackOfPlates.push(9);
//        stackOfPlates.push(3);
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(10);
        s1.push(2);
        s1.push(1);
        s1.push(9);
        s1.push(30);
        s1.push(3);
        s1.push(20);
        s1.push(6);
        s1 = sortStack(s1);
        System.out.println(s1);
    }
}
