package org.usc.demo.stringTemplate;

import org.stringtemplate.v4.ST;


/**
 *
 * @author ShunLi
 */
public class StringTemplateTest {
    public static void main(String[] args) {
        String subject = "$status$$clientAccountId$ $clientAccountName$ - Trade Settlement Instruction on $businessDate$";
        ST st = new ST(subject);

    }

}
