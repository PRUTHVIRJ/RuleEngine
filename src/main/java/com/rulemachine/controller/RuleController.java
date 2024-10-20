package com.rulemachine.controller;



import com.rulemachine.model.ExpressionNode;
import com.rulemachine.model.LogicalNode;
import com.rulemachine.model.Node;
import com.rulemachine.model.UserAttributes;
import com.rulemachine.service.RuleService;
import org.aspectj.weaver.ast.ASTNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    // Create a new rule
    @PostMapping(value = "/create" )
    public String createRule(@RequestBody String expression) {
       LogicalNode returnNode = ruleService.createRule(expression);
        return (returnNode==null)?"error":returnNode.toString();
    }

    @GetMapping("/{id}")
    public Node getRuleById(@PathVariable Long id) {
        Node rule = ruleService.getRuleById(id);
        return rule;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<Boolean> evaluateRule(@RequestBody Map<String, String> request) {
        boolean result = ruleService.evaluateRule(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/combine")
    public ResponseEntity<String> combineRules(@RequestBody List<String> rules) {
        LogicalNode combinedAST = ruleService.combineRules(rules);
        return ResponseEntity.ok((combinedAST==null)?"error":combinedAST.toString());
    }
}
