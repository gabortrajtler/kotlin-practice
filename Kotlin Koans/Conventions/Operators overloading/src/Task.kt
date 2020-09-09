import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval): MyDate {
    return addTimeIntervals(timeIntervals.timeInterval, timeIntervals.multiplier)
}

operator fun TimeInterval.times(multiplier: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, multiplier)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val multiplier: Int)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
