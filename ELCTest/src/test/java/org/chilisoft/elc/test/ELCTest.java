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
		elEngine.createNewContext();
		elEngine.setVariable("a", 14);
		elEngine.setVariable("b", "12345678");
		elEngine.parse("__a+__b");
	}

	@Test
	public void addition_1a(){
		elEngine.setVariable("x", 0.1001);
		elEngine.setVariable("y", 1);
		elEngine.parse("x+y");
	}

	@Test
	public void addition_1b(){
		elEngine.setVariable("x", -2.0001);
		elEngine.setVariable("y", 1.0001);
		elEngine.parse("x+y");
	}
}
