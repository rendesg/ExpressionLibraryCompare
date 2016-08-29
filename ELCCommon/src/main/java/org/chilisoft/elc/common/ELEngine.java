package org.chilisoft.elc.common;

/**
 * An abstract wrapper for Expression Libraries.
 * Created by rendesg on 2016.08.29.
 */
public interface ELEngine
{
	/**
	 * Parses an expression
	 * @param expression
	 */
	public void parse(String expression);

    public void setVariable(String key, Object value);

    public void createNewContext();

}
