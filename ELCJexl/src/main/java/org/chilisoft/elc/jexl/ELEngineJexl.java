package org.chilisoft.elc.jexl;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class ELEngineJexl implements ELEngine {

    JexlEngine engine;
    JexlContext context;
    Expression expression;

    @PostConstruct
    public void init(){
        engine = new JexlEngine();
        context = new MapContext();
    }

    public void createNewContext(){
        context = new MapContext();
    }

    public Object parse(String expression){
        expression = expression.replaceAll("__","");
        this.expression = engine.createExpression(expression);
        Object result = this.expression.evaluate(context);
        return result;
    }

    public void setVariable(String key, Object value){
        context.set(key,value);
    }

    public Set<String> getVariablesSet(String expression) {
        throw new NotImplementedException();
    }
}
