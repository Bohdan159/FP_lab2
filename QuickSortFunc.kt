package secondlab


class QuickSortFunc: SortFunc() {

    override fun sort(data: List<Int>?): SortingResult? {
        return if (data == null || data.isEmpty()) null else {
            val list = data.toMutableList()

            val timestamp = System.currentTimeMillis()

            SortingResult(
                quickSort(list, 0, data.size.minus(1)),
                System.currentTimeMillis() - timestamp
            )
        }
    }

    private fun quickSort(list: MutableList<Int>, begin: Int, end: Int): List<Int> {
        if (begin < end) {
            val partitionIndex = partition(list, begin, end)

            quickSort(list, begin, partitionIndex.minus(1))
            quickSort(list, partitionIndex.plus(1), end)
        }

        return list
    }

    private fun partition(list: MutableList<Int>, begin: Int, end: Int): Int {
        val pivot = list[end]
        var i = begin.minus(1)

        (begin until end).forEach { j ->
            if (list[j] <= pivot) {
                i++

                swap(list, i, j)
            }
        }

        swap(list, i.plus(1), end)

        return i.plus(1)
    }

    private fun swap(list: MutableList<Int>, first: Int, second: Int): List<Int> {
        val swapTemp = list[first]

        list[first] = list[second]
        list[second] = swapTemp

        return list
    }
}
