package com.rulemachine.model;


public class LogicalNode extends ExpressionNode {
    String operator;
    ExpressionNode left;
    ExpressionNode right;

    public LogicalNode(String operator, ExpressionNode left, ExpressionNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
    @Override
    public boolean evaluate(Context context) {
        switch (operator) {
            case "AND":
                return left.evaluate(context) && right.evaluate(context);
            case "OR":
                return left.evaluate(context) || right.evaluate(context);
            default:
                throw new IllegalArgumentException("Unknown logical operator: " + operator);
        }
    }
}
