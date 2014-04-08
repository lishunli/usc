package org.usc.demo.lombok;

import org.usc.demo.lombok.model.Model;


/**
 *
 * @author Shunli
 */

public class Test {
    public static void main(String[] args) {
         Model model = new Model(20, "jjadsj", 1000);
         System.out.println(model);
         System.out.println(model.getAge());

    }
}
