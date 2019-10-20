package heapsort;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private List<T> heap = new ArrayList<>();

    @Override
    public void put(T item) {
        heap.add(item);
        if (heap.size() > 1) reheapifyUpward(Math.floorDiv(heap.size(), 2) - 1);
    }

    @Override
    public T pop() {
        if (heap.isEmpty()) throw new IndexOutOfBoundsException("The heap is empty!");
        if (heap.size() == 1) return heap.remove(0);

        T popped = heap.get(0);

        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        reheapifyDownward(0);

        return popped;
    }

    private void reheapifyDownward(int rootIndex) {
        if (rootIndex < Math.floorDiv(heap.size(), 2)) {

            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heap.size() && heap.get(rootIndex).compareTo(heap.get(leftChild)) < 0) {
                swap(rootIndex, leftChild);
                reheapifyDownward(leftChild);
            }

            if (rightChild < heap.size() && heap.get(rootIndex).compareTo(heap.get(rightChild)) < 0) {
                swap(rootIndex, rightChild);
                reheapifyDownward(rightChild);
            }
        }
    }

    private void reheapifyUpward(int rootIndex) {
        if (rootIndex < Math.floorDiv(heap.size(), 2) && rootIndex >= 0) {

            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heap.size() && heap.get(rootIndex).compareTo(heap.get(leftChild)) < 0) {
                swap(rootIndex, leftChild);
            }

            if (rightChild < heap.size() && heap.get(rootIndex).compareTo(heap.get(rightChild)) < 0) {
                swap(rootIndex, rightChild);
            }

            reheapifyUpward(rootIndex - 1);
        }
    }

    private void swap(int indexA, int indexB) {
        T temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }

    public List<T> getHeap() {
        return heap;
    }

    public void setHeap(List<T> heap) {
        this.heap = heap;
    }
}