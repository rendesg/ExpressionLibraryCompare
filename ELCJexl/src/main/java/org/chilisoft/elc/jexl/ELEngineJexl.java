package org.chilisoft.elc.jexl;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ELEngineJexl implements ELEngine {

    JexlEngine engine;
    JexlContext context;
    Expression expression;

    @PostConstruct
    public void init(){
        engine = new JexlEngine();
    }

    public void createNewContext(){
        context = new MapContext();
    }

    public void parse(String expression){
        expression = expression.replaceAll("__","");
        this.expression = engine.createExpression(expression);
        System.out.println("Eredmeny: " + this.expression.evaluate(context));
    }

    public void setVariable(String key, Object value){
        context.set(key,value);
    }
}
