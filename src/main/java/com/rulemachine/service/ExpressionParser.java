package com.rulemachine.service;

import com.rulemachine.model.ComparisonNode;
import com.rulemachine.model.ExpressionNode;
import com.rulemachine.model.LogicalNode;

import java.util.Stack;

public class ExpressionParser {
    String[] tokens;
    int pos = 0;

    public ExpressionParser(String[] tokens) {
        this.tokens = tokens;
    }

    // Entry point to parse the expression
    public LogicalNode parse() {
        Stack<ExpressionNode> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        while (pos < tokens.length) {
            String token = tokens[pos++];
            if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // pop '('
            } else if (token.equals("AND") || token.equals("OR")) {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek())) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else {
                // Token is a comparison, process it
                operandStack.push(parseComparison(token));
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }

        ExpressionNode rootNode=operandStack.pop();
        if(rootNode instanceof LogicalNode)
        {
            return (LogicalNode) rootNode;
        }
        return new LogicalNode("error",null,null);
    }

    // Precedence rules: AND > OR
    private int precedence(String operator) {
        return operator.equals("AND") ? 2 : 1;
    }

    // Parse a comparison like "age > 30"
    private ComparisonNode parseComparison(String firstToken) {
        String field = firstToken;
        String operator = tokens[pos++];
        String value = tokens[pos++];
        return new ComparisonNode(field, operator, value);
    }

    // Process operators, pop from stacks and create logical nodes
    private void processOperator(Stack<ExpressionNode> operandStack, Stack<String> operatorStack) {
        String operator = operatorStack.pop();
        ExpressionNode right = operandStack.pop();
        ExpressionNode left = operandStack.pop();
        operandStack.push(new LogicalNode(operator, left, right));
    }
}