package binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {
    private BSTNode<T> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // Add a node to the tree
    public void addNode(T nodeData) {
        if (root == null) {
            root = new BSTNode<>(nodeData);
        } else {
            root.add(nodeData);
        }
        size++;
    }

    // Print the tree in ascending order
    public void printTree() {
        if (root != null) {
            root.printTree();
            System.out.println();
        } else {
            System.out.println("Tree is empty.");
        }
    }

    // Print the tree in descending order
    public void printTreeDescending() {
        if (root != null) {
            root.printTreeDescending();
            System.out.println();
        } else {
            System.out.println("Tree is empty.");
        }
    }

    // Search for an item in the tree
    public boolean searchTree(T dataToFind) {
        return root != null && root.searchTree(dataToFind);
    }

    // Print the smallest item
    public void printSmallest() {
        if (root != null) {
            System.out.println("Smallest item: " + root.getSmallest());
        } else {
            System.out.println("Tree is empty.");
        }
    }

    // Print the largest item
    public void printLargest() {
        if (root != null) {
            System.out.println("Largest item: " + root.getLargest());
        } else {
            System.out.println("Tree is empty.");
        }
    }
}
