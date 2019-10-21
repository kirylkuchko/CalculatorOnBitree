package biTree;

public class Node {
    private Node parent;
    private String key;
    private Node left;
    private Node right;

    public Node(String key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
