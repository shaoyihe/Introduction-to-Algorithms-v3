package c6.p2;

import org.junit.Test;

import static c6.p2.Heap.*;

/**
 * Created by heshaoyi on 5/21/16.
 */
public class HeapPractise2 {
    /**
     * 6.2-5
     */
    @Test
    public void loopMaxHeapify() {
        int[] args = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        System.err.println("before loopMaxHeapify ");
        prettyPrint(args);
        int point = 1; // from 0
        maxHeapity(args, point);
        System.err.println("after loopMaxHeapify");
        prettyPrint(args);
    }

    public static void maxHeapity(int[] args, int heapSize, int point) {
        while (true) {
            int leftChildIndex = left(point);
            int rightChildIndex = right(point);
            int maxIndex = point;
            if (leftChildIndex < heapSize && args[maxIndex] < args[leftChildIndex]) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heapSize && args[maxIndex] < args[rightChildIndex]) {
                maxIndex = rightChildIndex;
            }
            if (maxIndex == point) {
                break;
            } else {
                swap(args, maxIndex, point);
                point = maxIndex;
            }
        }
    }

    public static void maxHeapity(int[] args, int point) {
        maxHeapity(args, args.length, point);
    }

    public static void swap(int[] args, int first, int second) {
        int local = args[first];
        args[first] = args[second];
        args[second] = local;
    }


}
