package org.chilisoft.elc.test;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@ComponentScan("org.chilisoft.elc")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
