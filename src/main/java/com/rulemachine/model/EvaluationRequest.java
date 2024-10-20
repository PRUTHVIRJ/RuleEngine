package com.rulemachine.model;

import java.util.Map;


public class EvaluationRequest {
    private Node ast; // AST generated for the rule
    private Map<String, Object> data; // User data to evaluate

    public Node getAst() {
        return ast;
    }

    public void setAst(Node ast) {
        this.ast = ast;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
// Getters and Setters
}
