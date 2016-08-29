package org.chilisoft.elc.spring;

import org.chilisoft.elc.common.ELEngine;
import org.springframework.stereotype.Component;

/**
 * Created by rendesg on 2016.08.29.
 */
@Component
public class ELEngineSpring implements ELEngine
{
	public void parse(String expression)
	{
		System.out.println("Hey, this is Spring engine!");
	}
}
