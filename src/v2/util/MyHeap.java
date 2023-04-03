package v2.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyHeap<T> {

    List<T> heap;

    Comparator<T> comparator;

    int currentIndex = -1;

    public void add(T element) {
        currentIndex++;
        if (currentIndex == heap.size()) {
            heap.add(element);
        } else {
            heap.set(currentIndex, element);
        }
        if (currentIndex != 0) {
            int childIndex = currentIndex;
            int parentIndex = (childIndex - 1) / 2;
            while (parentIndex > -1 && compare(heap.get(parentIndex), heap.get(childIndex)) > 0) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }
    }

    private void swap(int childIndex, int parentIndex) {
        T temp = this.heap.get(childIndex);
        this.heap.set(childIndex, this.heap.get(parentIndex));
        this.heap.set(parentIndex, temp);
    }

    private int compare(T element1, T element2) {
        return comparator == null ? ((Comparable) element1).compareTo(element2) : comparator.compare(element1, element2);
    }

    public T remove() {
        T minElement = heap.get(0);
        heap.set(0, heap.get(currentIndex));
        int parentIndex = 0;
        while (true) {
            int childIndex1 = 2 * parentIndex + 1;
            int childIndex2 = childIndex1 + 1;
            int child1Compare = childIndex1 < currentIndex ? compare(heap.get(parentIndex), heap.get(childIndex1)) : -1;
            int child2Compare = childIndex2 < currentIndex ? compare(heap.get(parentIndex), heap.get(childIndex2)) : -1;
            if (child1Compare <= 0 && child2Compare <= 0) {
                break;
            } else if (child1Compare > 0 && child2Compare > 0) {
                if (compare(heap.get(childIndex1), heap.get(childIndex2)) > 0) {
                    swap(childIndex2, parentIndex);
                    parentIndex = childIndex2;
                } else {
                    swap(childIndex1, parentIndex);
                    parentIndex = childIndex1;
                }
            } else if (child1Compare > 0) {
                swap(childIndex1, parentIndex);
                parentIndex = childIndex1;
            } else if (child2Compare > 0) {
                swap(childIndex2, parentIndex);
                parentIndex = childIndex2;
            } else {
                break;
            }

        }
        currentIndex--;
        return minElement;
    }


    public MyHeap() {
        this.heap = new ArrayList<>();
    }

    public MyHeap(int size) {
        this.heap = new ArrayList<>(size);
    }

    public MyHeap(int size, Comparator<T> comparator) {
        this(size);
        this.comparator = comparator;
    }

    public MyHeap(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return currentIndex < 0;
    }
    public T peek(){
        return heap.get(0);
    }

}
