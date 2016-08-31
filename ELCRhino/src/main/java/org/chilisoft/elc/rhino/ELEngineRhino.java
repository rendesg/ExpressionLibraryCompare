package org.chilisoft.elc.rhino;

import org.chilisoft.elc.common.ELEngine;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NodeVisitor;
import org.springframework.stereotype.Component;
import org.mozilla.javascript.*;
import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by MogyorosiMate on 2016. 08. 30..
 */

@Component
public class ELEngineRhino implements ELEngine {

    Context context;
    Scriptable scope;

    @PostConstruct
    public void init(){
        context = Context.enter();
        scope = context.initStandardObjects();
        context.setLanguageVersion(Context.VERSION_1_8);
    }

    @Override
    public Object parse(String expression) {
        Object result = null;
        expression = expression.replaceAll("__", "");
        result = context.evaluateString(scope, expression, "<cmd>", 1, null);
        context.exit();
        return result;
    }

    @Override
    public void setVariable(String key, Object value) {
        scope.put(key,scope,value);
    }

    @Override
    public void createNewContext() {
        context = Context.enter();
        scope = context.initStandardObjects();
        context.setLanguageVersion(Context.VERSION_1_8);
    }

    @Override
    public Set<String> getVariablesSet(String expression) {
        expression = expression.replaceAll("__", "");
        Set<String> variables = new TreeSet<String>();
        AstNode node = new Parser().parse(expression, "<cmd>", 1);
        NodeVisitor nv = new NodeVisitor() {
            @Override
            public boolean visit(AstNode astNode) {
                if(astNode instanceof Name){
                    variables.add(astNode.getString());
                }
                return true;
            }
        };
        node.visit(nv);
        return variables;
    }
}
