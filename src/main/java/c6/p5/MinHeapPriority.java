package c6.p5;

import c6.p2.Heap;
import c6.p2.HeapPractise2;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by heshaoyi on 5/21/16.
 */
public class MinHeapPriority {
    private int[] args;
    private int heapSize;

    public MinHeapPriority(int[] args) {
        this.args = Arrays.copyOf(args, args.length + 10);
        this.heapSize = args.length;
        buildMinHeap();
    }

    public int minmum() {
        assert heapSize > 0;
        return args[0];
    }

    public int extractMin() {
        int min = minmum();
        HeapPractise2.swap(args, 0, heapSize - 1);
        minHeaprity(0);
        --heapSize;
        return min;
    }

    public void decreaseKey(int point, int newValue) {
        assert heapSize > point;
        assert args[point] >= newValue;
        args[point] = newValue;

        int parent = Heap.parent(point);
        while (parent >= 0) {
            if (args[parent] > args[point]) {
                HeapPractise2.swap(args, parent, point);
                point = parent;
                parent = Heap.parent(parent);
            } else {
                break;
            }
        }
    }


    private void buildMinHeap() {
        for (int i = heapSize / 2; i > 1; --i) {
            minHeaprity(i);
        }
    }

    private void minHeaprity(int point) {
        int leftIndex = Heap.left(point);
        int rightIndex = Heap.right(point);
        int minIndex = point;
        if (leftIndex < heapSize && args[minIndex] > args[leftIndex]) {
            minIndex = leftIndex;
        }
        if (rightIndex < heapSize && args[minIndex] > args[rightIndex]) {
            minIndex = rightIndex;
        }
        if (minIndex != point) {
            HeapPractise2.swap(args, minIndex, point);
            minHeaprity(minIndex);
        }
    }

}
