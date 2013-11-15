package org.usc.demo.guava;

import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;

public class Partition<T> extends AbstractList<List<T>> {
    final List<T> list;
    final int size;

    Partition(List<T> list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public List<T> get(int index) {
        int listSize = size();
        Preconditions.checkElementIndex(index, listSize);
        int start = index * size;
        int end = Math.min(start + size, list.size());
        return list.subList(start, end);
    }

    @Override
    public int size() {
        return IntMath.divide(list.size(), size, RoundingMode.CEILING);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
