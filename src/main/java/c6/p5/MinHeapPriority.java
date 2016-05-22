package c6.p5;

import c6.p2.Heap;
import c6.p2.HeapPractise2;

import java.util.Arrays;

/**
 * Created by heshaoyi on 5/21/16.
 */
public class MinHeapPriority {
    private int[] elements;
    private int heapSize;

    public MinHeapPriority(int[] args) {
        this.elements = Arrays.copyOf(args, args.length + 10);
        this.heapSize = args.length;
        buildMinHeap();
    }

    public int minmum() {
        assert heapSize > 0;
        return elements[0];
    }

    public int extractMin() {
        int min = minmum();
        HeapPractise2.swap(elements, 0, heapSize - 1);
        --heapSize;
        minHeaprity(0);
        return min;
    }

    public void decreaseKey(int point, int newValue) {
        assert heapSize > point;
        assert elements[point] >= newValue;
        elements[point] = newValue;

        int parent = Heap.parent(point);
        while (parent >= 0) {
            if (elements[parent] > elements[point]) {
                HeapPractise2.swap(elements, parent, point);
                point = parent;
                parent = Heap.parent(parent);
            } else {
                break;
            }
        }
    }

    /**
     * 6.5-6
     *
     * @param point
     * @param newValue
     */

    public void decreaseKey2(int point, int newValue) {
        assert heapSize > point;
        assert elements[point] >= newValue;
        elements[point] = newValue;

        int oriPointVal = elements[point];
        int parent = Heap.parent(point);
        while (parent >= 0) {
            if (elements[parent] > oriPointVal) {
                elements[point] = elements[parent];
                point = parent;
                parent = Heap.parent(parent);
            } else {
                break;
            }
        }
        elements[point] = oriPointVal;
    }

    public MinHeapPriority insert(int value) {
        if (heapSize >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + 10);
        }
        elements[heapSize++] = Integer.MAX_VALUE;
        decreaseKey(heapSize - 1, value);
        return this;
    }

    public void print() {
        Heap.prettyPrint(elements, heapSize);
    }

    private void buildMinHeap() {
        for (int i = heapSize / 2; i >= 0; --i) {
            minHeaprity(i);
        }
    }

    private void minHeaprity(int point) {
        int leftIndex = Heap.left(point);
        int rightIndex = Heap.right(point);
        int minIndex = point;
        if (leftIndex < heapSize && elements[minIndex] > elements[leftIndex]) {
            minIndex = leftIndex;
        }
        if (rightIndex < heapSize && elements[minIndex] > elements[rightIndex]) {
            minIndex = rightIndex;
        }
        if (minIndex != point) {
            HeapPractise2.swap(elements, minIndex, point);
            minHeaprity(minIndex);
        }
    }

}
