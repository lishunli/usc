package org.usc.demo.guava;

import java.util.AbstractList;
import java.util.List;

import com.google.common.base.Preconditions;

public class Distribution<T> extends AbstractList<List<T>> {
    final List<T> list;
    final int parts;

    Distribution(List<T> list, int parts) {
        this.list = list;
        this.parts = parts;
    }

    @Override
    public List<T> get(int index) {
        Preconditions.checkElementIndex(index, size());
        int listSize = list.size();
        int partSize = listSize / parts;
        int largeParts = listSize % parts;
        int largeSize = partSize + 1;

        // Parts [0, largeParts) have size largeSize, the rest have size partSize.
        if (index < largeParts) {
            int chunkStart = largeSize * index;
            return list.subList(chunkStart, chunkStart + largeSize);
        }

        int largeEnd = largeParts * largeSize;
        int chunkStart = largeEnd + (index - largeParts) * partSize;
        return list.subList(chunkStart, chunkStart + partSize);
    }

    @Override
    public int size() {
        return parts;
        // return Math.min(list.size(), parts);
    }
}
