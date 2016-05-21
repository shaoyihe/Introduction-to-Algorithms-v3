package c6.p4;

import c6.p2.HeapPractise2;
import org.junit.Test;

import static c6.p2.Heap.*;

/**
 * Created by heshaoyi on 5/21/16.
 */
public class HeapPractise4 {

    /**
     * sort heap sample
     */
    @Test
    public void sortHeap() {
        int[] args = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        System.err.println("before sortHeap ");
        prettyPrint(args);

        buildMaxHep(args);
        for (int i = args.length - 1; i > 0; --i) {
            HeapPractise2.swap(args, 0, i);
            HeapPractise2.maxHeapity(args, i, 0);
        }

        System.err.println("after sortHeap ");
        prettyPrint(args);
    }

    public void buildMaxHep(int[] args) {
        for (int i = args.length / 2; i >= 0; --i) {
            HeapPractise2.maxHeapity(args, i);
        }
    }
}
