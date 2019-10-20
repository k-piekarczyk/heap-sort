import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void put() {
        List<Integer> expectedOrder = Arrays.asList(9, 3, 1, 2);

        Heap<Integer> heap = new Heap<>();
        heap.put(2);
        heap.put(3);
        heap.put(1);
        heap.put(9);

        assertEquals(expectedOrder, heap.getHeap());
    }

    @Test
    void pop() {
        List<Integer> startOrder = new ArrayList<>();
        startOrder.add(9);
        startOrder.add(3);
        startOrder.add(1);
        startOrder.add(2);
        List<Integer> expectedOrder = Arrays.asList(3, 2, 1);

        Heap<Integer> heap = new Heap<>();
        heap.setHeap(startOrder);

        assertEquals(9, heap.pop());
        assertEquals(expectedOrder, heap.getHeap());

        while (heap.getHeap().size() > 0) heap.pop();

        assertThrows(IndexOutOfBoundsException.class, heap::pop);
    }
}