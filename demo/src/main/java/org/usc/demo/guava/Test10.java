package org.usc.demo.guava;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimaps;

/**
 *
 * @author Shunli
 */
public class Test10 {
    public static void main(String[] args) {
        List<Ccy> ccys1 = ImmutableList.of(new Ccy("i1", "a", 1), new Ccy("i2", "b", 2), new Ccy("i1", "a", 2));
        List<Ccy> ccys2 = ImmutableList.of(new Ccy("i1", "a", 1), new Ccy("i2", "b", 2), new Ccy("i1", "a", 2));

        final ImmutableListMultimap<CcyKey, Ccy> grouped = Multimaps.index(Iterables.concat(ccys1, ccys2), new Function<Ccy, CcyKey>() {
            @Override
            public CcyKey apply(Ccy input) {
                return new CcyKey(input.getId(), input.getName());
            }
        });
        // System.out.println(grouped);

        // method 1
        Iterable<Ccy> transform = Iterables.transform(grouped.keySet(), new Function<CcyKey, Ccy>() {
            @Override
            public Ccy apply(CcyKey ccyKey) {
                int sumMoneys = sumMoneys(grouped.get(ccyKey));
                return new Ccy(ccyKey.getId(), ccyKey.getName(), sumMoneys);
            }
        });
        System.out.println(ImmutableList.copyOf(transform));

        // method 2
        Builder<Ccy> builder = ImmutableList.builder();
        for (CcyKey ccyKey : grouped.keySet()) {
            int sumMoneys = sumMoneys(grouped.get(ccyKey));
            builder.add(new Ccy(ccyKey.getId(), ccyKey.getName(), sumMoneys));
        }
        List<Ccy> groupedAndSumList = builder.build();
        System.out.println(groupedAndSumList);

    }

    private static int sumMoneys(List<Ccy> ccyList) {
        if (ccyList == null) {
            return 0;
        }

        int moneys = 0;
        for (Ccy ccy : ccyList) {
            moneys += ccy.getMoney();
        }

        return moneys;
    }
}
