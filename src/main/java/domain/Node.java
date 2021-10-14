package main.java.domain;

public class Node {
    private final Integer key;
    private final String value;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
