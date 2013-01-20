package org.usc.demo.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class ListUtil {
    public static <T> List<List<T>> doSubList(List<T> list, int blockSize) {
        List<List<T>> lists = new ArrayList<List<T>>(blockSize);

        if (list != null && blockSize > 0) {
            int listSize = list.size();
            int batchSize = listSize / blockSize;
            int remain = listSize % blockSize;

            for (int i = 0; i < blockSize; i++) {
                int fromIndex = i * batchSize + (i < remain ? i : remain);
                int toIndex = fromIndex + batchSize + (i < remain ? 1 : 0);
                lists.add(list.subList(fromIndex, toIndex));
            }
        }

        return lists;
    }
}
