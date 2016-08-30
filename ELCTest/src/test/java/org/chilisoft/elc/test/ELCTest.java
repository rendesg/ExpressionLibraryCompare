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

    private static final double delta = 0.00005;

    //Multiply
    @Test
    public void addition_1a(){
        elEngine.setVariable("x", 0.1001);
        elEngine.setVariable("y", 1);
        Double expected = 1.1001;
        Double result = (Double)elEngine.parse("__x+__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void addition_2a(){
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", 1.0001);
        Double expected = -1.0000;
        Double result = (Double)elEngine.parse("__x+__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void addition_3a(){
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);
        Double expected = 8.0001;
        Double result = (Double)elEngine.parse("__x+__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void addition_3b(){
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "1");
        Double expected = 3.0022;
        Double result = (Double)elEngine.parse("__x+__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void addition_3c(){
        elEngine.setVariable("x", "12.0119");
        elEngine.setVariable("y", "9");
        Double expected = 21.0119;
        Double result = (Double)elEngine.parse("__x+__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    //Substraction

    @Test
    public void substraction_1a(){
        elEngine.setVariable("x", 1.1002);
        elEngine.setVariable("y", 1);
        Double expected =  0.1002;
        Double result = (Double)elEngine.parse("__x-__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void substraction_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 1.0411);
        Double expected =  -3.1415;
        Double result = (Double)elEngine.parse("__x-__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void substraction_3a(){
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);
        Double expected =  2.0001;
        Double result = (Double)elEngine.parse("__x-__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void substraction_3b(){
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "1");
        Double expected =  1.0022;
        Double result = (Double)elEngine.parse("__x-__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void substraction_3c(){
        elEngine.setVariable("x", "12.0119");
        elEngine.setVariable("y", "9");
        Double expected =  3.0119;
        Double result = (Double)elEngine.parse("__x-__y");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    /*
	 * Multipilcation
	 */

    @Test
    public void multiply_1a() {
        elEngine.setVariable("x", 1.1002);
        elEngine.setVariable("y", 2);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(2.2004, (Double)retval, delta);
    }

    @Test
    public void multiply_2a() {
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(-2.1006, (Double)retval, delta);
    }

    @Test
    public void multiply_2b() {
        elEngine.setVariable("x", 2.1004);
        elEngine.setVariable("y", -1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(-2.1006, (Double)retval, delta);
    }

    @Test
    public void multiply_2c() {
        elEngine.setVariable("x", -2.1404);
        elEngine.setVariable("y", -1.0001);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(2.1406, (Double)retval, delta);
    }

    @Test
    public void multiply_3a() {
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);

        Object retval = elEngine.parse("__x * __y");
        assertEquals(15.0003, (Double)retval, delta);
    }

    @Test
    public void multiply_3b() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2");

        Object retval = elEngine.parse("__x * __y");
        assertEquals(4.0044, (Double)retval, delta);
    }

    @Test
    public void multiply_3c() {
        elEngine.setVariable("x", "12.0113");
        elEngine.setVariable("y", "3");

        Object retval = elEngine.parse("__x * __y");
        assertEquals(36.0339, (Double)retval, delta);
    }

    /*
     * Division
     */

    @Test
    public void divide_1a() {
        elEngine.setVariable("x", 2.0002);
        elEngine.setVariable("y", 1.0551);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.8957, (Double)retval, delta);
    }

    @Test
    public void divide_2a() {
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", 1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(-1.9997, (Double)retval, delta);
    }

    @Test
    public void divide_2b() {
        elEngine.setVariable("x", 2.0001);
        elEngine.setVariable("y", -1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(-1.9997, (Double)retval, delta);
    }

    @Test
    public void divide_2c() {
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", -1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, (Double)retval, delta);
    }

    @Test
    public void divide_3a() {
        elEngine.setVariable("x", "2.0001");
        elEngine.setVariable("y", 1.0002);

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, (Double)retval, delta);
    }

    @Test
    public void divide_3b() {
        elEngine.setVariable("x", 2.0001);
        elEngine.setVariable("y", "1.0002");

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, (Double)retval, delta);
    }

    @Test
    public void divide_3c() {
        elEngine.setVariable("x", "2.0001");
        elEngine.setVariable("y", "1.0002");

        Object retval = elEngine.parse("__x / __y");
        assertEquals(1.9997, (Double)retval, delta);
    }

    //Complex expressions
    @Test
    public void complex1(){
        elEngine.setVariable("a", 1);
        elEngine.setVariable("b", 2);
        elEngine.setVariable("c", 3);
        Double expected =  9.0;
        Double result = (Double)elEngine.parse("(__a+__b)*__c");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void complex1_byPeti(){
        elEngine.setVariable("a", 1);
        elEngine.setVariable("b", 2);
        elEngine.setVariable("c", 3);
        Double expected =  9.0;
        Object result = elEngine.parse("(__a+__b)*__c");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void complex2(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        Double expected =  7.0;
        Double result = (Double)elEngine.parse("__a+__b*__c");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void complex3(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        elEngine.setVariable("d", 4.0);
        elEngine.setVariable("e", 5.0);
        Double expected =  6.2;
        Double result = (Double)elEngine.parse("__a + __b * __c - __d / __e");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }

    @Test
    public void complex4(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        elEngine.setVariable("d", 4.0);
        elEngine.setVariable("e", 5.0);
        Double expected =  -0.6;
        Double result = (Double)elEngine.parse("(__a + __b) * (__c - __d) / __e");
        result = (double)Math.round(result * 10000d) / 10000d;
        assertEquals(expected,result);
    }
}
