package c6.p5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by heshaoyi on 5/21/16.
 */
public class HeapPratise5 {
    @Test
    public void minHeap() {
        MinHeapPriority minHeapPriority = new MinHeapPriority(new int[]{10, 2, 4, 2, 3});
        minHeapPriority.print();
        Assert.assertEquals(minHeapPriority.minmum(), 2);
        minHeapPriority.insert(-1).insert(1);
        minHeapPriority.print();
        Assert.assertEquals(minHeapPriority.minmum(), -1);
        Assert.assertEquals(minHeapPriority.extractMin(), -1);
        minHeapPriority.print();
        Assert.assertEquals(minHeapPriority.minmum(), 1);

        // 6.5-6
        minHeapPriority.decreaseKey2(5, -9);
        minHeapPriority.print();
        Assert.assertEquals(minHeapPriority.minmum(), -9);
    }
}
