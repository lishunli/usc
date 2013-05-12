package org.usc.demo.beanutils.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;
import org.usc.demo.beanutils.model.User;
import org.usc.demo.beanutils.model.UserAdapter;

/**
 * @author ShunLi
 *
 */
public class BeanUtilsTest6 {
    private User user;
    private List<String> params;

    @Before
    public void init() {
        user = new User("lishunli", "lishunli", 23, new Date());

        params = new ArrayList<String>();
        params.add("1");
        params.add("2");

        user.setParams(params);

    }

    @Test
    public void test1() throws Exception {
        UserAdapter ua = new UserAdapter();
        // BeanUtils.copyProperties(ua, user);

        // PropertyUtils.copyProperties(ua, user);

        PropertyUtils.setProperty(ua, "userName", user.getUsername());
        System.out.println(ua);
    }

}
