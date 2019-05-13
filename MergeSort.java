package secondlab;


public class MergeSort extends Sort {

    @Override
    public void sort(int[] data) {
        if (data != null && data.length != 0) {
            long timestamp = System.currentTimeMillis();

            setRawData(data);
            mergeSort(getRawData(), getRawData().length);

            setSortingTime(System.currentTimeMillis() - timestamp);
        }
    }

    private void mergeSort(int[] array, int length) {
        if (length < 2) return;

        int mid = length / 2;

        int[] left = new int[mid];
        int[] right = new int[length - mid];

        System.arraycopy(array, 0, left, 0, mid);

        if (length - mid >= 0) {
            System.arraycopy(array, mid, right, 0, length - mid);
        }

        mergeSort(left, mid);
        mergeSort(right, length - mid);

        merge(array, left, right, mid, length - mid);
    }

    private void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            }
            else {
                array[k++] = r[j++];
            }
        }

        while (i < left) {
            array[k++] = l[i++];
        }

        while (j < right) {
            array[k++] = r[j++];
        }

        setSortedData(array);
    }
}
