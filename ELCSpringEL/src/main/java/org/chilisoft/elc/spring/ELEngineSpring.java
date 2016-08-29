package org.chilisoft.elc.spring;

import org.chilisoft.elc.common.ELEngine;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by rendesg on 2016.08.29.
 */
@Component
public class ELEngineSpring implements ELEngine
{
	private ExpressionParser parser;
	private StandardEvaluationContext context;

	@PostConstruct
	public void init() {
		this.parser = new SpelExpressionParser();
		this.context = new StandardEvaluationContext();
	}

	public Object parse(String expression)
	{
		expression = expression.replaceAll("__", "#");
		Expression expr = parser.parseExpression(expression);

		Object retval = expr.getValue(context);
		System.out.println( "Eredmeny: " + retval );

		return retval;
	}

	public void setVariable(String key, Object value) {
		this.context.setVariable(key, value);
	}

	public void createNewContext() {
		this.context = new StandardEvaluationContext();
	}
}
