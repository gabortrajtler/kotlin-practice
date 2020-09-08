data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        if (this == other ) return 0
        if (year > other.year) {
            return 1
        } else if (year == year) {
            if (month > other.month) {
                return 1
            } else if (month == other.month) {
                if (dayOfMonth > other.dayOfMonth) {
                    return 1
                }
            }
        }
        return -1
    }

    fun compareToNicer(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
