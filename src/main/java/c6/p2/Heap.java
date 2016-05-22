package c6.p2;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.*;

/**
 * Created by heshaoyi on 5/21/16.
 * <p>
 * pretty print heap
 */
public class Heap {

    public static void prettyPrint(int[] args, int heapSize) {
        final String FILL_SPACE = " ";
        int maxLength = Arrays.stream(args).map(a -> String.valueOf(a).length()).max().getAsInt();
        if (maxLength % 2 == 1) {
            maxLength++;
        }
        final int heapHeight = (int) Math.floor(Math.log(heapSize) / Math.log(2));

        final int defaultOffset = 2;
        final Map<Integer, Integer> cache = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int curHeapHeight = heapHeight; curHeapHeight >= 0; --curHeapHeight) {
            int next = (int) (Math.pow(2, curHeapHeight + 1) - 1);
            StringBuilder line = new StringBuilder();
            for (int j = (int) (Math.pow(2, curHeapHeight) - 1); j < next; j++) {
                int curLeftOffset = 0;
                int validOffset = 0;
                //最后一层,找偏差
                boolean isFirst = !cache.containsKey(j - 1);
                if (curHeapHeight == heapHeight) {
                    curLeftOffset = cache.getOrDefault(j - 1, 0) + (isFirst ? 0 : maxLength) + defaultOffset;
                    validOffset = defaultOffset;
                } else { //上层找子节点
                    Integer leftChildOffset = cache.get(left(j));
                    Integer rightChildOffset = cache.get(right(j));
                    curLeftOffset = leftChildOffset + maxLength + (rightChildOffset - leftChildOffset - maxLength) / 2 - maxLength / 2;
                    validOffset = curLeftOffset - cache.getOrDefault(j - 1, 0) - (isFirst ? 0 : maxLength);
                }
                cache.put(j, curLeftOffset);
                if (j < heapSize) {
                    line.append(Strings.repeat(FILL_SPACE, validOffset)).append(fillCenter(maxLength, args[j]));
                }
            }
            result.add(0, line.toString());
        }
        result.forEach(System.err::println);
    }

    public static void prettyPrint(int[] args) {
        prettyPrint(args, args.length);
    }

    public static String fillCenter(int totalLength, int content) {
        return Strings.padStart(String.valueOf(content), totalLength, '0');
    }

    public static int left(int cur) {
        return 2 * cur + 1;
    }

    public static int right(int cur) {
        return 2 * cur + 2;
    }

    public static int parent(int cur) {
        return (int) (Math.ceil((double) cur / 2) - 1);
    }


    /* get

        *                                                                16

                                    14                                                              10
                    08                              07                              09                              03
            02              04              01              09              16              14              10              08
        07      09      03      02      04      01      09      16      14      10      08      07      09      03      02      04
      01  09  16  14  10  08  07  09  03  02  04  01  09

     */
    @Test
    public void test() {
        prettyPrint(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 9, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 9, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 9, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 9});
    }
}
