package org.chilisoft.elc.test;

import org.chilisoft.elc.common.ELEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by rendesg on 2016.08.29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ELCTest
{
	@Autowired
	private ELEngine elEngine;

	@Test
	public void exampleTest() {
		elEngine.parse("1+2");
	}
}
