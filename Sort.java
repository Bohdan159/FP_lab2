package secondlab;


abstract class Sort {

    private int[] rawData;
    private int[] sortedData;
    private long sortingTime;


    void setRawData(int[] data) {
        this.rawData = data;
    }

    int[] getRawData() {
        return rawData;
    }

    void setSortedData(int[] data) {
        this.sortedData = data;
    }

    public int[] getSortedData() {
        return sortedData;
    }

    void setSortingTime(long time) {
        this.sortingTime = time;
    }

    long getSortingTime() {
        return sortingTime;
    }

    public abstract void sort(int[] data);
}
