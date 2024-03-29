public interface HeapInterface<T extends Comparable<T>> {
    void put(T item);

    T pop();
}