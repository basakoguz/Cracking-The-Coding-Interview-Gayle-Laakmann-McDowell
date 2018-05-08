public class MyStack {

    StackNode topNode;
    int currSize = 0;
    int maxSize = 4;
    MyStack next;
    int maxValue;
    int minValue;

    public MyStack() {}

    public MyStack(StackNode topNode) {
        this.topNode = topNode;
    }

}
