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
        Object result = elEngine.parse("__x+__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void addition_2a(){
        elEngine.setVariable("x", -2.0001);
        elEngine.setVariable("y", 1.0001);
        Double expected = -1.0000;
        Object result = elEngine.parse("__x+__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void addition_3a(){
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);
        Double expected = 8.0001;
        Object result = elEngine.parse("__x+__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void addition_3b(){
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "1");
        Double expected = 3.0022;
        Object result = elEngine.parse("__x+__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void addition_3c(){
        elEngine.setVariable("x", "12.0119");
        elEngine.setVariable("y", "9");
        Double expected = 21.0119;
        Object result = elEngine.parse("__x+__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    //Substraction

    @Test
    public void substraction_1a(){
        elEngine.setVariable("x", 1.1002);
        elEngine.setVariable("y", 1);
        Double expected =  0.1002;
        Object result = elEngine.parse("__x-__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void substraction_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 1.0411);
        Double expected =  -3.1415;
        Object result = elEngine.parse("__x-__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void substraction_3a(){
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 3);
        Double expected =  2.0001;
        Object result = elEngine.parse("__x-__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void substraction_3b(){
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "1");
        Double expected =  1.0022;
        Object result = (Double)elEngine.parse("__x-__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void substraction_3c(){
        elEngine.setVariable("x", "12.0119");
        elEngine.setVariable("y", "9");
        Double expected =  3.0119;
        Object result = elEngine.parse("__x-__y");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
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
        Object result = elEngine.parse("(__a+__b)*__c");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }


    @Test
    public void complex2(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        Double expected =  7.0;
        Object result = elEngine.parse("__a+__b*__c");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void complex3(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        elEngine.setVariable("d", 4.0);
        elEngine.setVariable("e", 5.0);
        Double expected =  6.2;
        Object result = elEngine.parse("__a + __b * __c - __d / __e");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    @Test
    public void complex4(){
        elEngine.setVariable("a", 1.0);
        elEngine.setVariable("b", 2.0);
        elEngine.setVariable("c", 3.0);
        elEngine.setVariable("d", 4.0);
        elEngine.setVariable("e", 5.0);
        Double expected =  -0.6;
        Object result = elEngine.parse("(__a + __b) * (__c - __d) / __e");
        assertEquals(expected ,Double.parseDouble(result.toString()), delta);
    }

    /*
     * Logical Equal - with numbers
     */

    @Test
    public void logicalEqual_1a() {
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqual_1b() {
        elEngine.setVariable("x", 3.1101);
        elEngine.setVariable("y", 3.1101);

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalEqual_2a() {
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqual_2b() {
        elEngine.setVariable("x", -1.1404);
        elEngine.setVariable("y", -1.1404);

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalEqual_3a() {
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 5);

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqual_3b() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2.0022");

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalEqual_3c() {
        elEngine.setVariable("x", "2.0022");
        elEngine.setVariable("y", "2.0022");

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    /*
     * Logical Not equal - with numbers
     */

    @Test
    public void logicalNotEqual_1a() {
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_1b() {
        elEngine.setVariable("x", 3.1101);
        elEngine.setVariable("y", 3.1101);

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_2a() {
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_2b() {
        elEngine.setVariable("x", -1.1404);
        elEngine.setVariable("y", -1.1404);

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_3a() {
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 5);

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_3b() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2.0022");

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalNotEqual_3c() {
        elEngine.setVariable("x", "2.0022");
        elEngine.setVariable("y", "2.0022");

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }


    //Logical - less

    @Test
    public void logicalLess_1a(){
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLess_1b(){
        elEngine.setVariable("x", 3.1100);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLess_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLess_2b(){
        elEngine.setVariable("x", -0.1405);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLess_3a(){
        elEngine.setVariable("x", "5.0001"); //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("y", 5);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLess_3b(){
        elEngine.setVariable("x", 2.0021); //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("y", "2.0022");
        Boolean expected =  true;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }
    @Test
    public void logicalLess_3c(){
        elEngine.setVariable("x", "2.0021");
        elEngine.setVariable("y", "2.0022");
        Boolean expected =  true;
        Object result = elEngine.parse("__x<__y");
        assertEquals(expected ,result);
    }

    //Logical - less or equal
    @Test
    public void logicalLessOrEqual_1a(){
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_1b(){
        elEngine.setVariable("x", 3.1101);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_1c(){
        elEngine.setVariable("x", 3.1100);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_2b(){
        elEngine.setVariable("x", -1.1404);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_2c(){
        elEngine.setVariable("x", -1.1403);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_3a(){ //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 5);
        Boolean expected =  false;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_3b(){ //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("x",  2.0022);
        elEngine.setVariable("y",  "2.0022");
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalLessOrEqual_3c(){
        elEngine.setVariable("x",  "2.0022");
        elEngine.setVariable("y",  "2.0023");
        Boolean expected =  true;
        Object result = elEngine.parse("__x<=__y");
        assertEquals(expected ,result);
    }

    //Logical - greater

    @Test
    public void logicalGreater_1a(){
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreater_1b(){
        elEngine.setVariable("x", 3.1100);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  false;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreater_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);
        Boolean expected =  false;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreater_2b(){
        elEngine.setVariable("x", -0.1405);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreater_3a(){
        elEngine.setVariable("x", "5.0001"); //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("y", 5);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreater_3b(){
        elEngine.setVariable("x", 2.0021); //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("y", "2.0022");
        Boolean expected =  false;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }
    @Test
    public void logicalGreater_3c(){
        elEngine.setVariable("x", "2.0021");
        elEngine.setVariable("y", "2.0022");
        Boolean expected =  false;
        Object result = elEngine.parse("__x>__y");
        assertEquals(expected ,result);
    }

    //Logical - greater or equal
    @Test
    public void logicalGreaterOrEqual_1a(){
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", 1);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_1b(){
        elEngine.setVariable("x", 3.1101);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_1c(){
        elEngine.setVariable("x", 3.1100);
        elEngine.setVariable("y", 3.1101);
        Boolean expected =  false;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_2a(){
        elEngine.setVariable("x", -2.1004);
        elEngine.setVariable("y", 2.1004);
        Boolean expected =  false;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_2b(){
        elEngine.setVariable("x", -1.1404);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_2c(){
        elEngine.setVariable("x", -1.1403);
        elEngine.setVariable("y", -1.1404);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_3a(){ //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("x", "5.0001");
        elEngine.setVariable("y", 5);
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_3b(){ //Ha X és Y azonos típusú akkor működik double - double, int - int, egyébként hiba
        elEngine.setVariable("x",  2.0022);
        elEngine.setVariable("y",  "2.0022");
        Boolean expected =  true;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    @Test
    public void logicalGreaterOrEqual_3c(){
        elEngine.setVariable("x",  "2.0022");
        elEngine.setVariable("y",  "2.0023");
        Boolean expected =  false;
        Object result = elEngine.parse("__x>=__y");
        assertEquals(expected ,result);
    }

    /*
     * Logical Equal - with strings
     */

    @Test
    public void logicalEqualString_1a() {
        elEngine.setVariable("x", "alma");
        elEngine.setVariable("y", "alma");

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalEqualString_1b() {
        elEngine.setVariable("x", "körte");
        elEngine.setVariable("y", "alma");

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqualString_2a() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2.0022");

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalEqualString_2b() {
        elEngine.setVariable("x", 2.0022);
        elEngine.setVariable("y", "2.0023");

        Object retval = elEngine.parse("__x == __y");
        assertEquals(false, retval);
    }

    @Test
    public void logicalEqualString_3a() {
        elEngine.setVariable("x", "2.0022");
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqualString_3b() {
        elEngine.setVariable("x", "false");
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    /*
     * Logical Not equal - with strings
     */

    @Test
    public void logicalNotEqualString_1a() {
        elEngine.setVariable("x", "alma");
        elEngine.setVariable("y", "alma");

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalNotEqualString_1b() {
        elEngine.setVariable("x", "körte");
        elEngine.setVariable("y", "alma");

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqualString_2a() {
        elEngine.setVariable("x", 1.0001);
        elEngine.setVariable("y", "alma");

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqualString_3a() {
        elEngine.setVariable("x", "alma");
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqualString_3b() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", "true");

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    /*
     * Logical Equal - with boolean values
     */

    @Test
    public void logicalEqualBooelan_1a() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x == __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalEqualBooelan_1b() {
        elEngine.setVariable("x", false);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x == __y");
        assertTrue((Boolean) retval);
    }

    /*
     * Logical Not equal - with boolean values
     */

    @Test
    public void logicalNotEqualBoolean_1a() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x != __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalNotEqualBoolean_1b() {
        elEngine.setVariable("x", false);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x != __y");
        assertFalse((Boolean) retval);
    }

    /*
     * Logical And - with boolean values
     */

    @Test
    public void logicalAndBoolean_1a() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x && __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalAndBoolean_1b() {
        elEngine.setVariable("x", false);
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x && __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalAndBoolean_1c() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x && __y");
        assertTrue((Boolean) retval);
    }

    /*
     * Logical Or - with boolean values
     */

    @Test
    public void logicalOrBoolean_1a() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x || __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalOrBoolean_1b() {
        elEngine.setVariable("x", false);
        elEngine.setVariable("y", false);

        Object retval = elEngine.parse("__x || __y");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalOrBoolean_1c() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x || __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalOrBoolean_2a() {
        elEngine.setVariable("x", true);
        elEngine.setVariable("y", null);

        Object retval = elEngine.parse("__x || __y");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalOrBoolean_2b() {
        elEngine.setVariable("x", null);
        elEngine.setVariable("y", true);

        Object retval = elEngine.parse("__x || __y");
        assertTrue((Boolean) retval);
    }

    /*
     * Logical Not - with boolean values
     */

    @Test
    public void logicalNotBoolean_1a() {
        elEngine.setVariable("x", true);

        Object retval = elEngine.parse("!__x");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalNotBoolean_1b() {
        elEngine.setVariable("x", false);

        Object retval = elEngine.parse("!__x");
        assertTrue((Boolean) retval);
    }

    /*
     * Complex logical expressions
     */

    @Test
    public void logicalComplex_1() {
        elEngine.setVariable("a", true);
        elEngine.setVariable("b", false);
        elEngine.setVariable("c", true);

        Object retval = elEngine.parse("(__a || __b) && __c");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalComplex_2() {
        elEngine.setVariable("a", true);
        elEngine.setVariable("b", false);
        elEngine.setVariable("c", true);

        Object retval = elEngine.parse("!(__a || __b) && __c");
        assertFalse((Boolean) retval);
    }

    @Test
    public void logicalComplex_3() {
        elEngine.setVariable("a", true);
        elEngine.setVariable("b", true);
        elEngine.setVariable("c", true);

        Object retval = elEngine.parse("!__a || __b && __c");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalComplex_4() {
        elEngine.setVariable("a", true);
        elEngine.setVariable("b", false);
        elEngine.setVariable("c", false);
        elEngine.setVariable("d", true);

        Object retval = elEngine.parse("__a && (__b == __c) && __d");
        assertTrue((Boolean) retval);
    }

    @Test
    public void logicalComplex_5() {
        elEngine.setVariable("a", true);
        elEngine.setVariable("b", false);
        elEngine.setVariable("c", false);
        elEngine.setVariable("d", true);
        elEngine.setVariable("e", false);

        Object retval = elEngine.parse("!__a || __b && __c != __d || __e");
        assertTrue((Boolean) retval);
    }
}
