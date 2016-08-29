package org.chilisoft.elc.test;

import org.chilisoft.elc.common.ELEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ELCTest
{
	@Autowired
	private ELEngine elEngine;

	@Test
	public void addition_1a(){
		elEngine.setVariable("x", 0.1001);
		elEngine.setVariable("y", 1);
		elEngine.parse("__x+__y");
	}

	@Test
	public void addition_1b(){
		elEngine.setVariable("x", -2.0001);
		elEngine.setVariable("y", 1.0001);
		elEngine.parse("__x+__y");
	}

	/*
	 * Szorzas
	 */
    @Test
    public void multiply_1a() {
        elEngine.setVariable("x", 1.1002);
        elEngine.setVariable("y", 2);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(2.2004, retval);
    }

    @Test
    public void multiply_2a() {
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(-2.1006, retval);
    }

    @Test
    public void multiply_2b() {
        elEngine.setVariable("x", 2.1004);
        elEngine.setVariable("y", -1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(-2.1006, retval);
    }

    @Test
    public void multiply_2c() {
        elEngine.setVariable("x", -2.1404);
        elEngine.setVariable("y", -1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(2.1006, retval);
    }

    @Test
    public void multiply_3a() {
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(15.0003, retval);
    }

    @Test
    public void multiply_3b() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2");

        Object retval = elEngine.parse("__x * __y");
        assertEquals(4.0044, retval);
    }

    @Test
    public void multiply_3c() {
        elEngine.setVariable("x", "12.0113");
        elEngine.setVariable("y", "3");

        Object retval = elEngine.parse("__x * __y");
        assertEquals(36.0339, retval);
    }

    /*
     * Osztas
     */

    @Test
    public void divide_1a() {
        elEngine.setVariable("x", 2.002);
        elEngine.setVariable("y", 1.0551);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.8957, retval);
    }

    @Test
    public void divide_2a() {
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", 1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(-1.9997, retval);
    }

    @Test
    public void divide_2b() {
        elEngine.setVariable("x", 2.0001);
        elEngine.setVariable("y", -1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(-1.9997, retval);
    }

    @Test
    public void divide_2c() {
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", -1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, retval);
    }

    @Test
    public void divide_3a() {
        elEngine.setVariable("x", "2.0001");
        elEngine.setVariable("y", 1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, retval);
    }

    @Test
    public void divide_3b() {
        elEngine.setVariable("x", 2.0001);
        elEngine.setVariable("y", "1.0002");

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, retval);
    }

    @Test
    public void divide_3c() {
        elEngine.setVariable("x", "2.0001");
        elEngine.setVariable("y", "1.0002");

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, retval);
    }
}
