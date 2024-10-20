package com.rulemachine.service;



import com.rulemachine.model.*;
import com.rulemachine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;
    // Create rule and store in DB
    public LogicalNode createRule(String expression) {
        Rule rule = new Rule(expression);
        rule= ruleRepository.save(rule);

        String[] tokens=expression.split("\\s");
        ExpressionParser expressionParser=new ExpressionParser(tokens);
        return expressionParser.parse();
    }

    public Node getRuleById(Long id) {
        Optional<Rule> rule=ruleRepository.findById(id);
        if (rule.isPresent())
        {
            return createASTFromRule(rule.get().getExpression());
        }
        return null;
    }

    // Parse a rule string and return the root node of AST
    public Node createASTFromRule(String ruleString) {
        // Simplified AST creation logic for this example.
        // You'd need a parser for actual rule strings.
        Node ageCondition = new Node("operand", "age > 30");
        Node departmentCondition = new Node("operand", "department == 'Sales'");
        Node andNode = new Node("operator", ageCondition, departmentCondition);
        return andNode; // For example rule
    }

    // Evaluate the AST with user attributes
    public boolean evaluateRule(Node node, UserAttributes user) {
        if (node.getType().equals("operand")) {
            // Simplified evaluation logic for operands
            String[] parts = node.getValue().split(" ");
            String attribute = parts[0];
            String operator = parts[1];
            String value = parts[2];

            // Assume user.get(attribute) works and returns the attribute value from UserAttributes.
            return evaluateCondition(user.get(attribute), operator, value);
        } else if (node.getType().equals("operator")) {
            // Evaluate left and right branches recursively
            boolean leftResult = evaluateRule(node.getLeft(), user);
            boolean rightResult = evaluateRule(node.getRight(), user);
            return node.getValue().equals("AND") ? (leftResult && rightResult) : (leftResult || rightResult);
        }
        return false;
    }

    private boolean evaluateCondition(String userValue, String operator, String ruleValue) {
        // Implement actual evaluation logic (e.g., age > 30)
        return true; // Simplified
    }

    public LogicalNode combineRules(List<String> rules) {
        LogicalNode resultNode=null;
        for(String rule:rules)
        {
            ExpressionParser expressionParser=new ExpressionParser(rule.split("\\s+"));
            LogicalNode tempNode=expressionParser.parse();
            if(resultNode==null)
            {
                resultNode=tempNode;
            }
            else {
                resultNode=new LogicalNode("OR",resultNode,tempNode);
            }
        }
        return resultNode;
    }

    public boolean evaluateRule(Map<String, String> data) {
        Context context=new Context();
        data.forEach((key,value)->{
            context.setValue(key,value);
        });

        List<Rule> rules=ruleRepository.findAll();
        List<String> expressions= rules.stream().map(rule -> rule.getExpression()).toList();
        LogicalNode rootNode=combineRules(expressions);
        return rootNode.evaluate(context);
    }
}

