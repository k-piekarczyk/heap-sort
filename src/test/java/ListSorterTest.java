import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ListSorterTest {

    @Test
    void sort() {
        double[] unsortedVector = {4, 6, 7, 3, 1, 9, 0, 5};
        double[] correctlySorted = {0, 1, 3, 4, 5, 6, 7, 9};

        ListSorter listSorter = new ListSorter();

        double[] output = listSorter.sort(unsortedVector);

        assertArrayEquals(correctlySorted, output);
    }
}