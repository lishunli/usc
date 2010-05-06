package com.taifook.mtss.mss;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * This test is simply load all the resource and see if there is any problem.
 */

public class DeploymentTest {

    @Test
    public void testLoadApplicationContext() {
        ClassPathXmlApplicationContext appContext =
            new ClassPathXmlApplicationContext(new String[] {"com/taifook/mtss/mss/DeploymentTest-context.xml"});

        appContext.close();
    }
}
