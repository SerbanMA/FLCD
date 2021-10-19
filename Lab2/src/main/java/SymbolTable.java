package main.java;

import main.java.domain.Node;
public class SymbolTable {

    private Integer key = 0;
    private Node root = null;

    public SymbolTable() {}

    public Integer add(String value)
    {
        Node newNode = getNewNode(value);
        Node currentNode = root;
        Node lateNode = null;

        while (currentNode != null) {
            lateNode = currentNode;

            if (value.equals(currentNode.getValue()))
                return currentNode.getKey();

            else if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.getLeftNode();

            else
                currentNode = currentNode.getRightNode();
        }

        if (lateNode == null)
            root = newNode;
        else if (value.compareTo(lateNode.getValue()) < 0)
            lateNode.setLeftNode(newNode);
        else if (value.compareTo(lateNode.getValue()) > 0)
            lateNode.setRightNode(newNode);

        return newNode.getKey();
    }

    public Integer getKey(String value) {
        Node node = root;

        while (node != null) {

            if (value.equals(node.getValue()))
                 return node.getKey();

            else if (value.compareTo(node.getValue()) < 0)
                node = node.getLeftNode();

            else
                node = node.getRightNode();
        }

        return null;
    }

    private Node getNewNode(String value) {
        this.key += 1;
        return new Node(key, value);
    }

    void inorder(Node root)
    {
        if (root != null) {
            inorder(root.getLeftNode());
            System.out.println(root.getKey() + " " + root.getValue());
            inorder(root.getRightNode());
        }
    }

    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();

        symbolTable.add("Ana");
        symbolTable.add("has");
        symbolTable.add("pear");
        symbolTable.add("apple");
        symbolTable.add("banana");
        symbolTable.add("ana");
        symbolTable.add("apple");

        symbolTable.inorder(symbolTable.root);
    }
}
