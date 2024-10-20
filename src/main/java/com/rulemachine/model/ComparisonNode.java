package com.rulemachine.model;


public class ComparisonNode extends ExpressionNode {
    String field;
    String operator;
    String value;

    public ComparisonNode(String field, String operator, String value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String toString() {
        return field + " " + operator + " " + value;
    }
    @Override
    public boolean evaluate(Context context) {
        String fieldValue = context.getValue(field); // Retrieve the field value from context
        switch (operator) {
            case ">":
                return Integer.parseInt(fieldValue) > Integer.parseInt(value);
            case "<":
                return Integer.parseInt(fieldValue) < Integer.parseInt(value);
            case "=":
                return fieldValue.equals(value.replace("'", ""));
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
