public class BinarySearchTree {

    Node root;

    public static class Node {
        Node left, right;
        int data;

        public Node() {}
        public Node(int data) {
            this.data = data;
        }
    }

    public void addNode(int data) {
        this.root = addNode(this.root, data);
    }

    private Node addNode(Node rootNode, int data) {
        if(rootNode == null) {
            rootNode = new Node(data);
        } else {
            if(data > rootNode.data) {
                rootNode.right = addNode(rootNode.right, data);
            }
            if(data <= rootNode.data) {
                rootNode.left = addNode(rootNode.left, data);
            }
        }
        return rootNode;
    }

    public void addElementArray(int[] arr) {
        if(arr.length == 1) {
            addNode(arr[0]);
        } else if(arr.length > 1){
            int toAdd = arr[arr.length/2];
            addNode(toAdd);
            int[] arr1 = new int[arr.length/2];
            int[] arr2 = new int[(arr.length/2)-isLengthEven(arr)];
            for(int i=0; i<arr.length/2; i++){
                arr1[i] = arr[i];
            }
            for(int i=(arr.length/2)+1; i<arr.length; i++){
                arr2[i-(arr.length/2)-1] = arr[i];
            }
            addElementArray(arr1);
            addElementArray(arr2);
        }
    }

    public int isLengthEven(int[] arr) {
        if(arr.length % 2 == 0) {
            return 1;
        }
        return 0;
    }

    public void printTree(Node root) {
        if(root == null) {
            return;
        }
        if(root != null) {
            System.out.println(root.data);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTree tree = new BinarySearchTree();
        tree.addElementArray(arr);
        tree.printTree(tree.root);
    }
 }
