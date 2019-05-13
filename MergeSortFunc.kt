package secondlab


class MergeSortFunc: SortFunc() {

    override fun sort(data: List<Int>?): SortingResult? {
        return if (data == null || data.isEmpty()) null else {
            val timestamp = System.currentTimeMillis()

            SortingResult(mergeSort(data), System.currentTimeMillis() - timestamp)
        }
    }

    private fun mergeSort(list: List<Int>): List<Int> {
        val mid = list.size.div(2)

        return if (mid == 0) list else merge(
            mergeSort(list.subList(0, mid)),
            mergeSort(list.subList(mid, list.size)),
            mutableListOf()
        )
    }

    private fun merge(first: List<Int>, second: List<Int>, accumulator: MutableList<Int>): List<Int> {
        when {
            first.isEmpty() -> accumulator.addAll(second)
            second.isEmpty() -> accumulator.addAll(first)
            else -> return if (first[0] <= second[0]) {
                accumulator.add(first[0])
                merge(first.subList(1, first.size), second, accumulator)
            } else {
                accumulator.add(second[0])
                merge(first, second.subList(1, second.size), accumulator)
            }
        }

        return accumulator
    }
}
