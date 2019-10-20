package heapsort;

public class ListSorter implements ListSorterAlgorithm {
    @Override
    public double[] sort(double[] unsortedVector) {
        double[] sortedVector = unsortedVector.clone();

        Heap<Double> heap = new Heap<>();

        for (double item : sortedVector) heap.put(item);

        for (int i = sortedVector.length - 1; i >= 0; i--) sortedVector[i] = heap.pop();

        return sortedVector;
    }
}