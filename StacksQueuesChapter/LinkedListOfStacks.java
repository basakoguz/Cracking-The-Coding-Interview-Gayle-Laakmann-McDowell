public class LinkedListOfStacks {
    MyStack headStack;

    public LinkedListOfStacks() {
        MyStack headStack = new MyStack();
        this.headStack = headStack;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);
        if(headStack.currSize == 0 && headStack.next == null) {
            headStack.topNode = newNode;
            headStack.currSize++;
            System.out.println("New data added.");
        } else if(headStack.currSize == headStack.maxSize) {
            MyStack newStack = new MyStack();
            newStack.next = headStack;
            headStack = newStack;
            System.out.println("Stack size full. New stack has been created.");
            headStack.topNode = newNode;
            headStack.currSize++;
            System.out.println("New data added.");
        } else if(headStack.currSize < headStack.maxSize) {
            newNode.next = headStack.topNode;
            headStack.topNode = newNode;
            headStack.currSize++;
            System.out.println("New data added.");
        }
        if(data < headStack.minValue) {
            headStack.minValue = data;
        }
        if(data > headStack.maxValue) {
            headStack.maxValue = data;
        }
    }

    public int pop() {
        if(headStack == null && headStack.next == null){
            return -999999;
        }
        if(headStack == null) {
            headStack = headStack.next;
            System.out.println("Stack is empty. Moving on to the next stack.");
        }
        int popped = headStack.topNode.data;
        headStack.topNode = headStack.topNode.next;
        return popped;
    }
}
