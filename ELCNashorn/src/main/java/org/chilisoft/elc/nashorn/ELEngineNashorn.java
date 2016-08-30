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


    @PostConstruct
    public void init() {
        this.engine = new ScriptEngineManager().getEngineByName("nashorn");
        this.context = new SimpleScriptContext();

    }

    public Object parse(String expression) {
        expression = expression.replaceAll("__", "");

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

        Set<String> retval = new TreeSet<>();

        Options options = new Options("nashorn");
        ErrorManager errors = new ErrorManager();
        Context context = new Context(options, errors, Thread.currentThread().getContextClassLoader());
        Source source = Source.sourceFor("foo", expression);
        Parser parser = new Parser(context.getEnv(), source, errors);

        List<Statement> statements = parser.parse().getBody().getStatements();
        for (Statement statement : statements) {
            _dig(((ExpressionStatement)statement).getExpression(), retval);
        }

        return retval;
    }

    private void _dig(Expression expression, Set<String> variables) {
        if (expression instanceof BinaryNode) {
            _dig(((BinaryNode)expression).lhs(), variables);
            _dig(((BinaryNode)expression).rhs(), variables);
        } else if (expression instanceof IdentNode) {
            variables.add(((IdentNode)expression).getName());
        }
    }

}
