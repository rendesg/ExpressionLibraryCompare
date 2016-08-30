package org.chilisoft.elc.common;

import java.util.Set;

/**
 * An abstract wrapper for Expression Libraries.
 * Created by rendesg on 2016.08.29.
 */
public interface ELEngine
{
	public Object parse(String expression);

    public void setVariable(String key, Object value);

    public void createNewContext();

    public Set<String> getVariablesSet(String expression);

}
