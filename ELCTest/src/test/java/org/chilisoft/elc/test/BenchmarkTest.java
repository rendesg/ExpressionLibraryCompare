package org.chilisoft.elc.test;

import org.chilisoft.elc.common.ELEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by MogyorosiMate on 2016. 09. 05..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BenchmarkTest {
    @Autowired
    private ELEngine elEngine;

    @Before
    public void before() {
        elEngine.createNewContext();
    }

    public void singleTest(){
        Random rand = new Random();

        elEngine.setVariable("a", rand.nextBoolean());
        elEngine.setVariable("b", rand.nextBoolean());
        elEngine.setVariable("c", rand.nextBoolean());
        elEngine.setVariable("d", rand.nextBoolean());
        elEngine.setVariable("e", rand.nextBoolean());
        elEngine.setVariable("f", rand.nextInt());
        elEngine.setVariable("g", rand.nextInt());
        elEngine.setVariable("h", rand.nextInt());
        elEngine.setVariable("i", rand.nextInt());
        elEngine.setVariable("j", rand.nextInt());
        elEngine.setVariable("k", randomString(rand));
        elEngine.setVariable("l", randomString(rand));
        elEngine.setVariable("m", randomString(rand));
        elEngine.setVariable("n", randomString(rand));
        elEngine.setVariable("o", randomString(rand));
        elEngine.setVariable("p", rand.nextDouble());
        elEngine.setVariable("q", rand.nextDouble());
        elEngine.setVariable("r", rand.nextDouble());


        elEngine.parse("__f-__i < __g*__h+__j || !__b && __c == __a");
        elEngine.parse("(__j != __f / __h) && __a || !__b == __d");
        elEngine.parse("__k == __m || __f * __g - __h / __j + __i && __o != __n || !__a && __b || __c");
        elEngine.parse("(__f + __k / __g - __o <= __a) && __d || !__c != __k >= __l");
        elEngine.parse("__p + __j > __i || !__a && __d == __k != __m != __m + __q * __f - __l" );
    }

    public void testBatch(){
        for(int i=0; i<1000; ++i){
            singleTest();
        }
    }

    public String randomString(Random rand){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            char c = chars[rand.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }


    @Test
    public void benchmarkTest(){
        long cold=0;
        long warm=0;
        for(int i=0; i<10; ++i){
            testBatch();
            if(i==0){
                cold=System.currentTimeMillis();
            } else if(i==9){
                warm=System.currentTimeMillis();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("benchmarktest.txt", true);
            PrintWriter writer = new PrintWriter(fileWriter);
            writer.println("benchmarkTest_boolean_1_TEST "+(warm-cold)/1000.0);
            writer.flush();
            writer.close();
            fileWriter.close();
        }catch(Exception e){
            //TODO
        }
    }
}
