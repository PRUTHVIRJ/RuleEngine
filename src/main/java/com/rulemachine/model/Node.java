package com.rulemachine.model;


public class Node {
    private String type;  // "operator" or "operand"
    private Node left;    // Left child (for operators)
    private Node right;   // Right child (for operators)
    private String value; // Operand value (e.g., age > 30)

    // Constructor for operand node
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Constructor for operator node
    public Node(String type, Node left, Node right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}


