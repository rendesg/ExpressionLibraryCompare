package org.chilisoft.elc.jexl;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;

@Component
public class ELEngineJexl implements ELEngine {
    public void parse(String expression){
        JexlEngine jexl = new JexlEngine();

        Expression e = jexl.createExpression( expression );

        JexlContext jc = new MapContext();
        jc.set("a", 1);
        jc.set("b", "2");

        Object o = e.evaluate(jc);
        System.out.println("EREDMENY: " + o);
    }
}
