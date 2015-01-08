package org.usc.demo.guava;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 *
 * @author Shunli
 */
public class Test12 {
    public static void main(String[] args) {
        List<Ccy> ccys1 = ImmutableList.of(new Ccy("i1", "a", 1), new Ccy("i2", "b", 2), new Ccy("i3", "c", 3));

        System.out.println(tryFind(ccys1, "1"));
    }

    private static Ccy tryFind(List<Ccy> ccys1, final String id) {
        return Iterables.tryFind(ccys1, new Predicate<Ccy>() {
            @Override
            public boolean apply(Ccy input) {
                return StringUtils.endsWith(input.getId(), id);
            }
        }).orNull();
    }

}
