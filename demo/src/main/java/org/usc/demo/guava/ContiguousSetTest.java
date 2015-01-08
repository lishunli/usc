package org.usc.demo.guava;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;

/**
 *
 * @author Shunli
 */
public class ContiguousSetTest {
    // private static final Function<CcyKey, Ccy> function = new Function<CcyKey, Ccy>() {
    // private int i = 0;
    //
    // @Override
    // public Ccy apply(CcyKey input) {
    // return new Ccy(input.getId(), input.getName(), i++);
    // }
    // };

    public static void main(String[] args) {
        ImmutableList<Integer> asList = ContiguousSet.create(Range.closed(1, 500), DiscreteDomain.integers()).asList();
        System.out.println(asList);

        List<CcyKey> ccys1 = ImmutableList.of(new CcyKey("i1", "a"), new CcyKey("i2", "b"), new CcyKey("i1", "a"));

        System.out.println(Lists.transform(ccys1, new Function<CcyKey, Ccy>() {
            private int i = 0;

            @Override
            public Ccy apply(CcyKey input) {
                return new Ccy(input.getId(), input.getName(), i++);
            }
        }));
        System.out.println(Lists.transform(ccys1, new Function<CcyKey, Ccy>() {
            private int i = 0;

            @Override
            public Ccy apply(CcyKey input) {
                return new Ccy(input.getId(), input.getName(), i++);
            }
        }));

        // List<Ccy> ccys1 = ImmutableList.of(new Ccy("i1", "a", 1), new Ccy("i2", "b", 2), new Ccy("i1", "a", 2));

    }
}
