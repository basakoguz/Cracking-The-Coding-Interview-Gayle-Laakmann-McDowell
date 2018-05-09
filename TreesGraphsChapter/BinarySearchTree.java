import java.util.*;

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
            if(data < rootNode.data) {
                rootNode.left = addNode(rootNode.left, data);
            }
        }
        return rootNode;
    }

    public void addElementArray(int[] arr) {
        addElementArray(arr, 0, arr.length-1);
    }

    public void addElementArray(int[] arr, int firstIndex, int lastIndex) {
        if(lastIndex-firstIndex == 0) {
            addNode(arr[firstIndex]);
        } else if(lastIndex - firstIndex > 0){
            int midIndex = firstIndex + ((lastIndex - firstIndex + 1)/2);
            int toAdd = arr[midIndex];
            addNode(toAdd);
            addElementArray(arr, 0, midIndex-1);
            addElementArray(arr, midIndex+1, lastIndex);
        }
    }

    public void printTree(Node root) {
        if(root != null) {
            HashSet<Node> visited = new HashSet<Node>();
            LinkedList<Node> printNext = new LinkedList<Node>();
            if(root != null) {
                printNext.add(root);
            }
            while(!printNext.isEmpty()) {
                Node temp = printNext.remove();
                System.out.println(temp.data);
                if(temp.left != null) {
                    printNext.add(temp.left);
                }
                if(temp.right != null) {
                    printNext.add(temp.right);
                }
            }
        }
    }

    public boolean isBST() {
        return isBST(this.root);
    }
    public boolean isBST(Node root) {
        if(root != null){
            if(root.left != null) {
                if(!(root.data > root.left.data)){
                    return false;
                }
                isBST(root.left);
            }
            if(root.right != null) {
                if(!(root.data < root.right.data)){
                    return false;
                }
                isBST(root.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTree tree = new BinarySearchTree();
        tree.addElementArray(arr);
        tree.printTree(tree.root);
        System.out.println(tree.isBST());
    }
 }
