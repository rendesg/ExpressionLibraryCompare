package org.chilisoft.elc.nashorn;

import jdk.nashorn.internal.ir.*;
import jdk.nashorn.internal.parser.Parser;
import jdk.nashorn.internal.runtime.Context;
import jdk.nashorn.internal.runtime.ErrorManager;
import jdk.nashorn.internal.runtime.Source;
import jdk.nashorn.internal.runtime.options.Options;
import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.*;
import java.util.*;

/**
 * Created by TothPeter on 2016. 08. 30..
 */
@Component
public class ELEngineNashorn implements ELEngine {

    private ScriptEngine engine;
    private SimpleScriptContext context;

    private MyNode nodeTree;
    private Set<String> variableSet;

    @PostConstruct
    public void init() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");

        this.createNewContext();

        this.nodeTree = new MyNode();
        this.variableSet = new TreeSet<>();
    }

    public Object parse(String expression) {
        expression = expression.replaceAll("__", "");

        getVariablesSet(expression);

        expression = "function add(a, b) { return +a + +b; };" +
                "function equals(a, b) { return a.toString() == b.toString();};" +
                nodeTree.toString();

        Object retval = null;

        try {
            retval = engine.eval(expression, this.context);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return retval;
    }

    public void setVariable(String key, Object value) {
        this.context.setAttribute(key, value, 100);

    }

    public void createNewContext() {
        this.context = new SimpleScriptContext();

    }

    public Set<String> getVariablesSet(String expression) {
        expression = expression.replaceAll("__", "");

        this.nodeTree = new MyNode();
        this.variableSet = new TreeSet<>();

        Options options = new Options("nashorn");
        ErrorManager errors = new ErrorManager();
        Context context = new Context(options, errors, Thread.currentThread().getContextClassLoader());
        Source source = Source.sourceFor("foo", expression);

        Parser parser = new Parser(context.getEnv(), source, errors);

        List<Statement> statements = parser.parse().getBody().getStatements();
        for (Statement statement : statements) {
            _dig(((ExpressionStatement)statement).getExpression(), this.nodeTree);
        }

        return this.variableSet;
    }

    private void _dig_old(Expression expression, Set<String> variables) {
        if (expression instanceof BinaryNode) {
            _dig_old(((BinaryNode)expression).lhs(), variables);
            _dig_old(((BinaryNode)expression).rhs(), variables);
        } else if (expression instanceof IdentNode) {
            variables.add(((IdentNode)expression).getName());
        }
    }

    private void _dig(Expression expression, MyNode currentNode) {
        if (expression instanceof BinaryNode) {
            BinaryNode bExpression = (BinaryNode)expression;
            Expression lhs = bExpression.lhs();
            Expression rhs = bExpression.rhs();

            String method = bExpression.toString();
            String lhsString = lhs.toString();
            int beg = method.indexOf(lhsString) + lhsString.length();
            char e;
            while ((e = method.charAt(beg)) == ')')
                ++beg;
            method = method.substring(beg, beg+3).replaceAll(" ", "");

            currentNode.setMethod(method);

            currentNode.setLeftNode(new MyNode());
            _dig(lhs, currentNode.getLeftNode());

            currentNode.setRightNode(new MyNode());
            _dig(rhs, currentNode.getRightNode());

        } else if (expression instanceof UnaryNode) {
            UnaryNode unaryNode = (UnaryNode)expression;
            currentNode.setMethod(expression.toString().charAt(0) + "");
            currentNode.setLeftNode(new MyNode());

            _dig(unaryNode.getExpression(), currentNode.getLeftNode());
        } else  if (expression instanceof IdentNode) {
            String variableName = ((IdentNode)expression).getName();

            this.variableSet.add(variableName);
            currentNode.setVariableName(variableName);

        } else if (expression instanceof LiteralNode) {
            currentNode.setVariableName(((LiteralNode) expression).getValue() + "");

        } else if (expression instanceof JoinPredecessorExpression) {
            JoinPredecessorExpression joinPredecessorExpression = (JoinPredecessorExpression)expression;
            _dig(joinPredecessorExpression.getExpression(), currentNode);

        }
    }

}
