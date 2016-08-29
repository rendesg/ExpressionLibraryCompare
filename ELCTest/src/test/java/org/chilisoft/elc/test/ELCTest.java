package org.chilisoft.elc.test;

import org.chilisoft.elc.common.ELEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ELCTest
{
	@Autowired
	private ELEngine elEngine;

	@Test
	public void exampleTest() {
		elEngine.setVariable("a", 14);
		elEngine.setVariable("b", "12345678");
		elEngine.parse("__a+__b");
	}

}
