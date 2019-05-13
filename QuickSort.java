package secondlab;


public class QuickSort extends Sort {

    @Override
    public void sort(int[] data) {
        if (data != null && data.length != 0) {
            long timestamp = System.currentTimeMillis();

            setRawData(data);
            quickSort(getRawData(), 0, getRawData().length - 1);

            setSortingTime(System.currentTimeMillis() - timestamp);
        }
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }

        setSortedData(array);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];

                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];

        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }
}
