package org.chilisoft.elc.nashorn;

import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.*;
import java.util.Map;
import java.util.TreeMap;

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
}
