package org.usc.demo.clazz;

import java.lang.reflect.Method;

/**
 *
 * @author Shunli
 */
public class Parent5 {
    public void doAction(String actionName) {
        try {
            Method declaredMethod = getClass().getDeclaredMethod(actionName);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this);
        } catch (Exception e) {
        }

    }

}
